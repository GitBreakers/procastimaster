/**
 * Copyright (C) 2017 Xillio GitBreakers (GitBreakers@xillio.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package nl.xillio.gitbreakers.procrastimaster.client.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Jorn on 07/07/2017.
 */
@Singleton
public class RequestHandlerFactory {
    private static final Logger LOGGER = LogFactory.getLog();
    private static final String BASE_URL = "http://127.0.0.1:8080";

    private final ObjectMapperService mapperService;

    @Inject
    public RequestHandlerFactory(ObjectMapperService mapperService) {
        this.mapperService = mapperService;
    }

    public RequestHandler request(String endpoint) {
        try {
            return new RequestHandler(new URL(BASE_URL + "/" + endpoint), mapperService);
        } catch (IOException e) {
            LOGGER.error("Failed to create request: " + e.getMessage());
        }
        return null;
    }
}
