package com.ultrapower.detection.supervision.service.auth;

import java.io.Serializable;


public class AccessToken implements Serializable {
		
    private String accessToken;

    private String refreshToken;

    private String expiresIn;

    private String username;

    private String serverTime;
	
}
