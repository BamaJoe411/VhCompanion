package hibi.vhcompanion;

import com.mojang.brigadier.arguments.StringArgumentType;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.minecraft.text.Text;

import java.io.IOException;

import static com.mojang.brigadier.builder.RequiredArgumentBuilder.argument;


public class ClientInit implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> {
            dispatcher.register(ClientCommandManager.literal("home").executes(ClientCommands::homeCommand));
            dispatcher.register(ClientCommandManager.literal("spawn").executes(ClientCommands::spawnCommand));
            dispatcher.register(ClientCommandManager.literal("guidebook").executes(ClientCommands::guidebookCommand));
            dispatcher.register(
                ClientCommandManager.literal("httpRequest")
                        .then(argument("key", StringArgumentType.string()))
                        .executes( context -> {
                            final String key = StringArgumentType.getString(context, "key");
                            try {
                                String response = HTTPRequest.sendPOST(key);
                                context.getSource().sendFeedback(Text.literal(response));
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            return 0;
                        })
            );
        });
    }
}
