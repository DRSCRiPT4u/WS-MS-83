/*
    This file is part of the WinterStory WinterStory Server, commands OdinMS-based
    Copyleft (L) 2016 - 2019 DrScript

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU Affero General Public License as
    published by the Free Software Foundation version 3 as published by
    the Free Software Foundation. You may not use, modify or distribute
    this program under any other version of the GNU Affero General Public
    License.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Affero General Public License for more details.

    You should have received a copy of the GNU Affero General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

/*
   @Author: Arthur L - Refactored command content into modules
*/
package client.command.commands.gm0;

import client.MapleCharacter;
import client.MapleClient;
import client.command.Command;
import client.inventory.Equip;
import client.inventory.Item;
import client.inventory.MapleInventory;
import client.inventory.MapleInventoryType;
import com.sun.corba.se.impl.interceptors.SlotTable;
import com.sun.org.apache.bcel.internal.classfile.Constant;
import constants.game.GameConstants;
import constants.inventory.EquipSlot;
import constants.inventory.EquipType;
import net.server.Server;
import net.server.channel.Channel;
import net.server.channel.handlers.InventoryMergeHandler;
import net.server.channel.handlers.InventorySortHandler;
import server.MapleItemInformationProvider;

public class ItemLevelCommand extends Command {
    {
        setDescription("");
    }

    @Override
    public void execute(MapleClient client, String[] params) {
        MapleInventory inv = client.getPlayer().getInventory(MapleInventoryType.getByType((byte)-1));
        String result = "";
        for(Item item : inv.list())
        {
            Equip equippedItem = (Equip) inv.getItem(item.getPosition());
            result += "#e" + MapleItemInformationProvider.getInstance().getName(item.getItemId()) + " - Level: #r" +String.valueOf(equippedItem.getItemLevel()) + "#k\r\n";
        }
        client.getPlayer().showHint(result);
    }
}
