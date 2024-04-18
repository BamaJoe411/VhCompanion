package hibi.vhcompanion;

import com.mojang.brigadier.arguments.StringArgumentType;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.minecraft.text.Text;
import java.io.IOException;

public class ClientInit implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> {
            dispatcher.register(ClientCommandManager.literal("home").executes(ClientCommands::homeCommand));
            dispatcher.register(ClientCommandManager.literal("spawn").executes(ClientCommands::spawnCommand));
            dispatcher.register(ClientCommandManager.literal("guidebook").executes(ClientCommands::guidebookCommand));
            dispatcher.register(
                ClientCommandManager.literal("httpRequest")
                        .then(ClientCommandManager.argument("name", StringArgumentType.string())
                            .executes( context -> {
                                final String name = StringArgumentType.getString(context, "name");
                                try {
                                    String response = PostRequest.sendPost(name);
                                    context.getSource().sendFeedback(Text.literal(response));
                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                                return 0;
                            })
                        )
            );
        });
    }
}

