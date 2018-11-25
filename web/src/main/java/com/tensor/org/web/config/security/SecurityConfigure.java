package com.tensor.org.web.config.security;

import com.tensor.org.api.utils.BusinessType;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

/**
 *
 * @author liaochuntao
 */
@Slf4j
public class SecurityConfigure {

    private final HashMap<String, String> securityUrls;

    public SecurityConfigure() {
        securityUrls = new HashMap<>();
    }

    public SecurityUrlOption init() {
        return new SecurityUrlOption();
    }

    public SecurityConfigure start() {
        return this;
    }

    public HashMap<String, String> getSecurityUrls() {
        return securityUrls;
    }

    public class SecurityUrlOption {

        public SecurityUrlOption() {}

        public SecurityUrlOption addMatcher(String url, BusinessType.RoleType roleType) {
            securityUrls.put(url, roleType.getRole());
            return this;
        }

        public SecurityConfigure build() {
            return start();
        }

    }

}
