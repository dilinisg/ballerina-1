/*
*  Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
*  Unless required by applicable law or agreed to in writing,
*  software distributed under the License is distributed on an
*  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
*  KIND, either express or implied.  See the License for the
*  specific language governing permissions and limitations
*  under the License.
*/
package org.wso2.ballerinalang.compiler.tree.expressions;

import org.ballerinalang.model.tree.NodeKind;
import org.ballerinalang.model.tree.expressions.AnnotationAttachmentAttributeNode;
import org.ballerinalang.model.tree.expressions.AnnotationAttachmentAttributeValueNode;
import org.wso2.ballerinalang.compiler.tree.BLangNodeVisitor;

/**
 * @since 0.94
 */
public class BLangAnnotAttachmentAttribute extends BLangExpression implements AnnotationAttachmentAttributeNode {

    public String name;
    public BLangAnnotAttachmentAttributeValue value;

    public BLangAnnotAttachmentAttribute(String name, BLangAnnotAttachmentAttributeValue value) {
        this.name = name;
        this.value = value;
    }

    public BLangAnnotAttachmentAttribute() {
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public AnnotationAttachmentAttributeValueNode getValue() {
        return value;
    }

    @Override
    public void setValue(AnnotationAttachmentAttributeValueNode value) {
        this.value = (BLangAnnotAttachmentAttributeValue) value;
    }

    @Override
    public void accept(BLangNodeVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public NodeKind getKind() {
        return NodeKind.ANNOTATION_ATTACHMENT_ATTRIBUTE;
    }

    @Override
    public String toString() {
        return "BLangAnnotAttributeValue: " + name + " " + value;
    }
}