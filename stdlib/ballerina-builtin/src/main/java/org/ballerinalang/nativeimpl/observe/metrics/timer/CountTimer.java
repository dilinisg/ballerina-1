/*
 *  Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.ballerinalang.nativeimpl.observe.metrics.timer;

import org.ballerinalang.bre.Context;
import org.ballerinalang.bre.bvm.BlockingNativeCallableUnit;
import org.ballerinalang.model.types.TypeKind;
import org.ballerinalang.model.values.BInteger;
import org.ballerinalang.model.values.BMap;
import org.ballerinalang.model.values.BStruct;
import org.ballerinalang.natives.annotations.Argument;
import org.ballerinalang.natives.annotations.BallerinaFunction;
import org.ballerinalang.natives.annotations.Receiver;
import org.ballerinalang.natives.annotations.ReturnType;
import org.ballerinalang.util.metrics.Tag;
import org.ballerinalang.util.metrics.Timer;

import java.util.ArrayList;
import java.util.List;

/**
 * Returns the number of times that stop has been called on this timer.
 */
@BallerinaFunction(
        orgName = "ballerina", packageName = "observe",
        functionName = "count",
        receiver = @Receiver(type = TypeKind.STRUCT, structType = "Timer",
                structPackage = "ballerina.observe"),
        args = {@Argument(name = "timer", type = TypeKind.STRUCT, structType = "Timer",
                structPackage = "ballerina.observe")},
        returnType = {@ReturnType(type = TypeKind.FLOAT)},
        isPublic = true
)
public class CountTimer extends BlockingNativeCallableUnit {

    @Override
    public void execute(Context context) {
        BStruct timerStruct = (BStruct) context.getRefArgument(0);
        String name = timerStruct.getStringField(0);
        String description = timerStruct.getStringField(1);
        BMap tagsMap = (BMap) timerStruct.getRefField(0);

        if (tagsMap != null) {
            List<Tag> tags = new ArrayList<>();
            for (Object key : tagsMap.keySet()) {
                tags.add(new Tag(key.toString(), tagsMap.get(key).stringValue()));
            }
            context.setReturnValues(new BInteger(Timer.builder(name).description(description).tags(tags).register()
                    .count()));

        } else {
            context.setReturnValues(new BInteger(Timer.builder(name).description(description).register().count()));
        }
    }
}
