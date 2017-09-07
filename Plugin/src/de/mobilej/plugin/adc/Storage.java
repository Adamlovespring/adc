/*
 *    Copyright (C) 2016 Björn Quentin
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *      http://www.apache.org/licenses/LICENSE-2.0
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package de.mobilej.plugin.adc;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.StoragePathMacros;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.Nullable;

/**
 * Storage for the plugin
 *
 * Created by bjoern on 01.06.2016.
 */
@State(name = "ADCSettings",
        storages = {@com.intellij.openapi.components.Storage(
                file = StoragePathMacros.APP_CONFIG + "/adc_settings.xml")})
public class Storage implements PersistentStateComponent<Storage> {

    private String lastSentText = "";
    private String installedOnDevices;

    @Nullable
    @Override
    public Storage getState() {
        return this;
    }

    @Override
    public void loadState(Storage storage) {
        XmlSerializerUtil.copyBean(storage, this);
    }

    public void setLastSentText(String lastSentText) {
        this.lastSentText = lastSentText;
    }

    public String getLastSentText() {
        return lastSentText;
    }

    public String getInstalledOnDevices() {
        return installedOnDevices;
    }

    public void setInstalledOnDevices(String installedOnDevices) {
        this.installedOnDevices = installedOnDevices;
    }
}
