/*
 * Copyright 2017 floragunn GmbH
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

package com.floragunn.custom.dummy;

import java.nio.file.Path;

import org.elasticsearch.common.settings.Settings;

import com.floragunn.searchguard.auth.AuthenticationBackend;
import com.floragunn.searchguard.user.AuthCredentials;
import com.floragunn.searchguard.user.User;

public class CustomAuthenticationBackend implements AuthenticationBackend {

    public CustomAuthenticationBackend(final Settings settings, final Path configPath) {
        super();
    }

    @Override
    public String getType() {
        return "CustomAuthenticationBackend";
    }

    @Override
    public User authenticate(final AuthCredentials credentials) {
        return new User(credentials.getUsername(), credentials.getBackendRoles(), credentials);
    }

    @Override
    public boolean exists(User user) {
        return true;
    }

}
