package net.rt5phantom.voidheart;

import net.rt5phantom.voidheart.exception.AlreadyExistingOptionException;
import net.rt5phantom.voidheart.exception.OptionDoesNotExistException;

import java.util.ArrayList;

/**
 * An object that allows a plugin developer to store and read their plugin's configuration settings.
 */
public class PluginConfiguration
{
    /**
     * An arraylist that stores the current set of ConfigOptions in an instance of this class.
     */
    private ArrayList<ConfigOption> Options;

    // ================================================= //
    // ============= Public Facing Methods ============= //
    // ================================================= //
    // ----------------------------------------- //
    // ----------- Add Option Methods ---------- //
    // ----------------------------------------- //
    /**
     * Adds a new option to the instance.
     * @param optionName The name of the new option.
     * @param value The value of the new option.
     * @throws AlreadyExistingOptionException Thrown when trying to add a duplicate-named option.
     */
    public void addOption(String optionName, String value) throws AlreadyExistingOptionException
    {
        if (searchOption(optionName) == false)  // If the program doesn't find a duplicate-named entry in the list
        {
            // Create a new ConfigOption object and add it to the list
            Options.add(new ConfigOption(optionName, value));
        }
        else  // If a duplicate is found
        {
            throw new AlreadyExistingOptionException(optionName, this.getClass().getSimpleName());  // Throw custom exception
        }
    }
    // -------------------------------------------- //
    // ----------- Remove Option Methods ---------- //
    // -------------------------------------------- //
    /**
     * Removes an option from the instance.
     * @param optionName The option to remove.
     * @throws OptionDoesNotExistException Thrown when trying to remove an option that does not exist.
     */
    public void removeOption(String optionName) throws OptionDoesNotExistException
    {
        int ReturnedOptionID = searchOptionsReturnPlace(optionName);  // Finds the entry of the option

        if (ReturnedOptionID != -1)  // If the program finds the option
        {
            // Remove the option from the list based upon the entry ID that was found
            Options.remove(ReturnedOptionID);
        }
        else  // If the option isn't found
        {
            throw new OptionDoesNotExistException(optionName, this.getClass().getSimpleName());  // Throw custom exception
        }
    }
    // -------------------------------------------- //
    // ----------- Search Option Methods ---------- //
    // -------------------------------------------- //
    /**
     * Searches for an option by name from the instance.
     * @param optionName The name of the option to search.
     * @return Returns whether an option was found.
     */
    public Boolean searchOption(String optionName)
    {
        // Loop through each option entry until we hit the end of the list
        for (int timesLooped = 0; timesLooped < Options.size(); timesLooped++)
        {
            // If the entry matches the one we are searching for
            if (Options.get(timesLooped).getName().equals(optionName))
            {
                return true;  // Return true because we found a match
            }
        }
        return false;  // Return false because we found nothing after looping through the whole list of options
    }
    // ----------------------------------------- //
    // ----------- Get Option Methods ---------- //
    // ----------------------------------------- //
    /**
     * Gets an ConfigOption from the current instance based upon an option's name.
     * @param optionName The name of the option to return.
     * @return Returns the found ConfigOption object.
     * @throws OptionDoesNotExistException Thrown when trying to get an option that does not exist.
     */
    public ConfigOption getOptionObject(String optionName) throws OptionDoesNotExistException
    {
        int ReturnedOptionID = searchOptionsReturnPlace(optionName);  // Finds the entry of the option

        if (ReturnedOptionID != -1)  // If the program finds the option
        {
            return Options.get(ReturnedOptionID);  // Return that option
        }
        else  // If the option isn't found
        {
            throw new OptionDoesNotExistException(optionName, this.getClass().getSimpleName());  // Throw custom exception
        }
    }
    /**
     * Gets the value from the current instance based upon an option's name.
     * @param optionName The name of the option to find the value.
     * @return Returns the value of the option.
     * @throws OptionDoesNotExistException Thrown when trying to get an option that does not exist.
     */
    public String getOptionValue(String optionName) throws OptionDoesNotExistException
    {
        int ReturnedOptionID = searchOptionsReturnPlace(optionName);  // Finds the entry of the option

        if (ReturnedOptionID != -1)  // If the program finds the option
        {
            return Options.get(ReturnedOptionID).getValue();  // Return that option's name
        }
        else  // If the option isn't found
        {
            throw new OptionDoesNotExistException(optionName, this.getClass().getSimpleName());  // Throw custom exception
        }
    }
    /**
     * Gets all options from the current instance.
     * @return Returns options in the form of an ArrayList of ConfigOption objects.
     */
    public ArrayList<ConfigOption> getAllOptions() { return Options; }



    // ==================================================== //
    // ============= Internal Private Methods ============= //
    // ==================================================== //
    /**
     * Searches for an option by name and returns its place.
     * @param optionName The name of the option to search.
     * @return Returns the place of the option in list. Will return -1 if nothing is found.
     */
    private int searchOptionsReturnPlace(String optionName)
    {
        // Loop through each option entry until we hit the end of the list
        for (int timesLooped = 0; timesLooped < Options.size(); timesLooped++)
        {
            // If the entry matches the one we are searching for
            if (Options.get(timesLooped).getName().equals(optionName))
            {
                return timesLooped;  // Return the entry number
            }
        }
        return -1;  // Return -1 because we found nothing
    }
}