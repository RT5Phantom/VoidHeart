package net.rt5phantom.voidheart.exception;

/**
 * A custom exception which is used when an instance of PluginConfiguration cannot find an option it is told exists.
 */
public class OptionDoesNotExistException extends Exception
{
    /**
     * Basic constructor for the OptionDoesNotExistException that sends the exception.
     * @param optionName The ConfigOption's name that was duplicated.
     * @param configurationName The PluginConfiguration's name in which the exception occurred.
     */
    public OptionDoesNotExistException(String optionName, String configurationName)
    {
        // Sending exception message to console, loggers, etc...
        super("An exception has occurred within the VoidHeart framework! An option named '" + optionName + "' doesn't exist in the " + configurationName + " configuration!");
    }
}