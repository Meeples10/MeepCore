# MeepCore

Shared code for Meeples10's plugins.

## Commands

|Command|Description|Permission|
|-------|-----------|----------|
|`/meepcore`|Shows the plugin's help message.|`meepcore.use`|
|`/meepcore help`|Shows the plugin's help message.|`meepcore.use`|
|`/meepcore reload`|Reloads the plugin.|`meepcore.use`|
|`/meepcore debug`|Shows the values defined in the config file and the messages for the user's current locale.|`meepcore.use`|
|`/meepcore suite`|Shows a list of all installed plugins that list MeepCore as a dependency.|`meepcore.use`|
|`/meepcore locales`|Shows a list of locales supported by each plugin that lists MeepCore as a dependency.|`meepcore.use`|

## Configuration

The default configuration file can be found [here](https://github.com/Meeples10/MeepCore/blob/master/src/main/resources/config.yml).

|Key|Description|
|---|-----------|
|`color-scheme`|The color scheme of MeepCore and the plugins that depend on it.<br>- `0` for MeepCore style<br>- `1` for Essentials style<br>- `2` for muted style|
|`fallback-locale`|If a language file is not found for a player's locale, the plugin will fall back to this language.|
