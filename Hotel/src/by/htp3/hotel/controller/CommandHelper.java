package by.htp3.hotel.controller;

import java.util.HashMap;
import java.util.Map;



import by.htp3.hotel.command.Command;
import by.htp3.hotel.command.impl.*;



public final class CommandHelper {

	private static final CommandHelper instance = new CommandHelper();

	private Map<CommandName, Command> commands = new HashMap<>();

	private CommandHelper() {
		commands.put(CommandName.LOGINATION, new Logination());
		commands.put(CommandName.CHANGE_LANGUAGE, new ChangeLanguage());
		commands.put(CommandName.SHOW_FREE_ROOMS, new GetFreeRooms());
		commands.put(CommandName.ADD_NEW_ROOM, new AddNewRoom());
		commands.put(CommandName.ADD_NEW_ROOM_FORM, new AddNewRoomForm());
		commands.put(CommandName.GO_REGISTRATION, new GoRegistrationForm());
		commands.put(CommandName.GO_LOGINATION, new GoLoginationForm());
		commands.put(CommandName.REGISTRATION, new Registration());
		commands.put(CommandName.PERSONAL_ACCOUNT, new PersonalAccount());
		commands.put(CommandName.UPDETE_PERSONAL_ACCAUNT, new UpdetePersonalAccount());


	}

	public Command getCommand(String name) {
		name = name.replace('-', '_');
		CommandName commandName = CommandName.valueOf(name.toUpperCase());

		Command command = commands.get(commandName);

		return command;
	}

	public static CommandHelper getInstance() {
		return instance;
	}

}
