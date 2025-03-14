package com.swallows.additionalapi.command;

import com.swallows.additionalapi.Tags;
import com.swallows.additionalapi.util.rsa.RSA;
import com.swallows.additionalapi.util.rsa.RSAKey;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.security.KeyPair;

public class CommandCreativeRSA extends CommandBase  {

    public static final Logger LOGGER = LogManager.getLogger(Tags.MOD_NAME);

    @Override
    public String getName() {
        return "CreativeRSA"; // 命令名称
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "/CreativeRSA <Key-Size>\nKey-Size: 1024、2048、4096"; // 命令使用方法提示
    }

    @Override
    public int getRequiredPermissionLevel()
    {
        return 4;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {

        if(args.length ==1) {

            if(args[0] != null && args[0].matches("\\d+")) {

                int Size = Integer.parseInt(args[0]);

                if(Size == 1024 || Size == 2048 || Size == 4096) {

                    KeyPair keyPair = RSA.CreativeRSAKeys(Size);

                    if(keyPair != null) {
                        LOGGER.info(
                                "\n公钥: " + RSAKey.getBase64PublicKeyByKeyPair(keyPair) +
                                        "\n私钥: " + RSAKey.getBase64PrivateKeyByKeyPair(keyPair) +
                                        "\n请保存好公钥并保证不会被泄露！这可能会关乎到您服务器的安全！");
                        throw new CommandException("已生成至日志文件，请注意查看！");
                    }

                    else {
                        throw new CommandException("生成的公私钥对为空或未正确生成！");
                    }
                }

                else {
                    throw new CommandException("您输入的长度不合法！\n" + getUsage(sender));
                }
            }

            else {
                throw new CommandException(getUsage(sender));
            }
        }

        else {
            throw new CommandException(getUsage(sender));
        }
    }
}
