package com.hj.oauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * Created by niuruijing on 2018/5/10.
 * spring security oauth2.0 安全校验
 * 提供程序配置的一个重要方面是将授权代码提供给 OAuth 客户端（在授权代码授权中）的方式。
 *      OAuth 客户端通过将最终用户导向授权页面来获得授权码，其中用户可以输入其证书，
 *      导致从授权服务器重定向到具有授权码的 OAuth 客户端。
 */

/**
 *  EnableAuthorizationServer：
 *      配置 OAuth 2.0 授权服务器机制
 *      实现AuthorizationServerConfigurer的任何bean
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Autowired
    private UserDetailsService userDetailsService;

    /**
     * 定义令牌端点上的安全约束
     * @param oauthServer
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer.tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()");
    }

    /**
     * 定义客户端详细信息服务的配置器。客户详细信息可以初始化，或者可以引用现有的 store
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        System.out.println("------------------授权服务器机制:ClientDetailsServiceConfigurer------------------");
        clients.inMemory()
                //（必须的）客户端 id
                .withClient("hjcloud")
                //客户范围限制。如果范围未定义或为空（默认），客户端将不受范围限制
                .scopes("hjcloud")
                //客户端的密码
                .secret("hjcloud")
                //授权客户端使用的授予类型。默认值为空
                .authorizedGrantTypes("password", "authorization_code", "refresh_token")
                .autoApprove(true) ;
                //.authorities: 授权给客户的认证（常规 Spring Security 认证）
    }

    /**
     * 定义授权和令牌端点以及令牌服务
     * @param endpoints
     * @throws Exception
     */

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .tokenStore(new RedisTokenStore(redisConnectionFactory))
                .userDetailsService(userDetailsService)
                .authenticationManager(authenticationManager);
    }

}
