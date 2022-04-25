/*
 *  Copyright 1999-2021 Seata.io Group.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package io.seata.samples.sca.provider.service.impl;

import io.seata.samples.sca.provider.service.DubboEchoService;
import org.springframework.stereotype.Service;

/**
 * Created by yu.hb on 2019-10-30
 */
@Service
public class DubboEchoServiceImpl implements DubboEchoService {

    @Override
    public String echo(String name) {
        return "DubboEchoServiceImpl#echo hi " + name;
    }
}
