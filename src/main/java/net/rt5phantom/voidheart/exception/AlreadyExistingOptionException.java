package net.rt5phantom.voidheart.exception;

/**
 * A custom exception which is used when an instance of PluginConfiguration is told to add a ConfigOption with a name that already exists.
 */
public class AlreadyExistingOptionException extends Exception
{
    /**
     * Basic constructor for the AlreadyExistingOptionException that sends the exception.
     * @param optionName The ConfigOption's name that was duplicated.
     * @param configurationName The PluginConfiguration's name in which the exception occurred.
     */
    public AlreadyExistingOptionException(String optionName, String configurationName)
    {
        // Sending exception message to console, loggers, etc...
        super("An exception has occurred within the VoidHeart framework! An option named '" + optionName + "' already exists in the " + configurationName + " configuration!");
    }
}