package hibi.vhcompanion;

import com.mojang.brigadier.context.CommandContext;

import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

import java.io.IOException;

public class ClientCommands {
    public static int homeCommand(CommandContext<FabricClientCommandSource> context) {
        MinecraftClient client = MinecraftClient.getInstance();
        client.player.networkHandler.sendChatCommand("trigger cmd set 3");
        return 0;
    }

    public static int spawnCommand(CommandContext<FabricClientCommandSource> context) {
        MinecraftClient client = MinecraftClient.getInstance();
        client.player.networkHandler.sendChatCommand("trigger cmd set 1");
        return 0;
    }

    public static int guidebookCommand(CommandContext<FabricClientCommandSource> context) {
        MinecraftClient client = MinecraftClient.getInstance();
        client.player.networkHandler.sendChatMessage("vhguide book");
        return 0;
    }

//    public static int httpRequestCommand(CommandContext<FabricClientCommandSource> context) throws IOException {
//        MinecraftClient client = MinecraftClient.getInstance();
//        client.inGameHud.getChatHud().addMessage(Text.of("placeholder"));
//        HTTPRequest.sendPOST("Test");
//        return 0;
//    }
}
