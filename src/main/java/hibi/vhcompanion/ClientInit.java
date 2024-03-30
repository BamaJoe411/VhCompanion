package hibi.vhcompanion;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;


public class ClientInit implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> {
            dispatcher.register(ClientCommandManager.literal("home").executes(ClientCommands::homeCommand));
            dispatcher.register(ClientCommandManager.literal("spawn").executes(ClientCommands::spawnCommand));
            dispatcher.register(ClientCommandManager.literal("guidebook").executes(ClientCommands::guidebookCommand));
        });
    }
}
