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
package nl.xillio.gitbreakers.procrastimaster.client.controllers;

import javafx.collections.FXCollections;
import nl.xillio.gitbreakers.procrastimaster.client.TableEntry;
import nl.xillio.gitbreakers.procrastimaster.server.model.History;

public class HistoryController extends UserInfoController {
    public HistoryController() {
        super("History", FXCollections.observableArrayList(
                new TableEntry("Dwight", "Worked on story"),
                new TableEntry("Luca", "Did a thing"),
                new TableEntry("Pieter", "Wrote docs"),
                new TableEntry("Thomas", "Stuff")
        ));
    }

    public void update(History history) {
        this.clear();
        history.getUpdates().forEach(u -> {
            this.addNewEntry(u.getCreatedBy().getName(), u.getTodayIHave());
        });
    }
}
