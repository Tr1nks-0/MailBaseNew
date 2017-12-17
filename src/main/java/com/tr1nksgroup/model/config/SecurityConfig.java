package com.tr1nksgroup.model.config;

import com.tr1nksgroup.model.entities.enums.SiteRolesEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Arrays;

@Configuration
@EnableWebSecurity
@PropertySource("classpath:/properties/rootAdmin.properties")
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private static String HAS_ROLE = "hasRole('";
    private static String HAS_ANY_ROLE = "hasAnyRole('";
    private static String COMMA = "', '";
    private static String TAIL = "')";
    @Resource
    private DataSource dataSource;
    @Value("${admin.root.enabled}")
    private boolean enabledRootAdmin;
    @Value("${admin.root.email}")
    private String emailRootAdmin;
    @Value("${admin.root.password}")
    private String passwordRootAdmin;

    @Override
    public void configure(HttpSecurity security) throws Exception {
        security.authorizeRequests()
//                .antMatchers("/main/**").access(hasAnyRole(SiteRolesEnum.ADMIN, SiteRolesEnum.USER))
                .antMatchers("/c/**").access(hasAnyRole(SiteRolesEnum.ADMIN, SiteRolesEnum.USER))
                .antMatchers("/a/**").access(hasAnyRole(SiteRolesEnum.ADMIN))
                .antMatchers("/u/**").access(hasAnyRole(SiteRolesEnum.ADMIN, SiteRolesEnum.USER))
//                .antMatchers("/signup/**").permitAll()
                .antMatchers("/index/**").permitAll()

                .and().formLogin()
                .loginPage("/login").defaultSuccessUrl("/c/main", false).failureUrl("/index?error=true")
                .and().logout()
                .logoutUrl("/logout").logoutSuccessUrl("/index")
                .and().csrf().disable();
    }

    /**
     * create a 'hasRole('.....')' string
     * for more readable security properties
     *
     * @param roles roles to be in 'hasRole('.....')'
     * @return string for properties
     */
    private static String hasAnyRole(SiteRolesEnum... roles) {
        StringBuilder builder = new StringBuilder(HAS_ANY_ROLE);
        Arrays.stream(roles).forEach(r -> builder.append(r.getRoleWithPrefix()).append(COMMA));
        return builder.replace(builder.lastIndexOf(COMMA), builder.lastIndexOf(COMMA) + 4, TAIL).toString();
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
        if (enabledRootAdmin) {
            builder.inMemoryAuthentication()
                    .withUser(emailRootAdmin)
                    .password(passwordRootAdmin)
                    .roles(SiteRolesEnum.ADMIN.getRole(), SiteRolesEnum.USER.getRole());
            builder.inMemoryAuthentication()
                    .withUser("e@r.c")
                    .password("root")
                    .roles(SiteRolesEnum.ADMIN.getRole(), SiteRolesEnum.USER.getRole());
        }
        builder.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select email, password,enabled  from user where email=?")
                .authoritiesByUsernameQuery("SELECT email, concat('ROLE_',role) FROM  user WHERE email=?");
    }
}
