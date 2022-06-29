/*
    Created in June 2022 as part of the Void Heart project by owner RT5Phantom. Subject to copy right under the Eclipse Public License, see https://github.com/RT5Phantom/VoidHeart/blob/master/LICENSE for more details.
*/

package net.rt5phantom.voidheart.exception;

/**
 * A custom exception which is used when an instance of PluginConfiguration is told to add a ConfigOption with a name that already exists.
 * @author RT5Phantom
 * @since v2.1.0
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