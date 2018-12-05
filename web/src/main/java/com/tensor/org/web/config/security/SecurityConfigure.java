package com.tensor.org.web.config.security;

import com.tensor.org.api.utils.BusinessType;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 *
 * @author liaochuntao
 */
@Slf4j
public class SecurityConfigure {

    private final HashMap<Pattern, String> securityUrls;

    public SecurityConfigure() {
        securityUrls = new HashMap<>();
    }

    public SecurityUrlOption init() {
        return new SecurityUrlOption();
    }

    public SecurityConfigure end() {
        return this;
    }

    public Map<Pattern, String> getSecurityUrls() {
        return Collections.unmodifiableMap(securityUrls);
    }

    public class SecurityUrlOption {

        SecurityUrlOption() {}

        public SecurityUrlOption addMatcher(String url, BusinessType.RoleType roleType) {
            securityUrls.put(Pattern.compile(url), roleType.getRole());
            return this;
        }

        public SecurityConfigure build() {
            return end();
        }

    }

}
