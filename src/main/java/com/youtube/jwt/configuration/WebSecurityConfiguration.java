package com.youtube.jwt.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	@Autowired
	private JwtRequestFilter jwtRequestFilter;

	@Autowired
	private UserDetailsService jwtService;

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.cors();
		httpSecurity.csrf().disable().authorizeRequests()
				.antMatchers("/authenticate", "/registerNewUser", "/task/{id}","/client", "/client-count", "/employee", "/admin",
						"/allEmployee", "/employee-count", "/employee/{emp_id}", "/lead", "/lead/{id}","/lead-count", "/deals",
						"/deals/{id}","/deal-count", "/employee/{emp_id}", "/createNewProject", "/shift", "/allclient", "/admin/data",
						"/getallProject","/project-count", "/shift/data", "/designations", "/departments","/designations/{id}", "/attendence",
						"/client/{clientId}", "/stickynote", "/stickynote/{stickyNoteId}", "{/loginDetails}","/designations/{id}","/accounts/{accountID}",
						"/contract", "/notice", "/product", "/product/{productId}", "/proposals","/proposals/{proposalId}",
						"/clockAttendance/clock-in","saveEvent","/events","/createTask","/task","/leaves","/leaves/{id}","/interview","/interview/{id}",
						"/clockAttendance/clock-out/{id}","/account","/account-data","/assets","/company","/award/{id}","/award","/appericiation","/appericiation/{id}",
						"/holiday","/holiday/{id}","/employee/{employeeId}","/clockAttendance/clock-out/{employeeId}/{attendanceDate}","/admin/{id}","/template","/proposals/{proposalId}","/company/{companyId}",
						"/project/{projectId}","/departments/{departmentId}","/skills","/skills/{skillId}")
				.permitAll().antMatchers(HttpHeaders.ALLOW).permitAll().anyRequest().authenticated().and()
				.exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(jwtService).passwordEncoder(passwordEncoder());
	}
}
