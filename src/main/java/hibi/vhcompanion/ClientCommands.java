package hibi.vhcompanion;

import com.mojang.brigadier.context.CommandContext;

import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.client.MinecraftClient;

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
}
