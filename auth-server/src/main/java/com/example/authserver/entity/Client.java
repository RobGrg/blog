package com.example.authserver.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="oauth_client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="client_id")
    private String clientId;

    @Column(name = "client_secret")
    private String clientSecret;

    @Column(name = "access_token_validity")
    private int accessTokenValidity;

    @Column(name = "scope")
    private String scope;

    private String authorities;

    @Column(name = "authorities_grant_type")
    private String authoritiesGrantType;

    @Column(name="refresh_token_validity")
    private int refreshTokenValidity;

    @Column(name="resource_ids")
    private String resourceIds;

    @Column(name="web_server_redirect_uri")
    private String webServerRedirectUri;

    @Column(name="autoapprove")
    private String autoApprove;

    @Column(name="additional_information")
    private String addInfo;
}
