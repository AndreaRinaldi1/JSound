package org.config;

import jsound.exceptions.CliException;

import java.util.HashMap;

public class JSoundRuntimeConfiguration {

    private static final String ARGUMENT_PREFIX = "--";
    private static final String ARGUMENT_FORMAT_ERROR_MESSAGE =
        "Invalid argument format. Required format: --property value";
    private HashMap<String, String> _arguments;
    private static JSoundRuntimeConfiguration instance;

    private JSoundRuntimeConfiguration(String[] args) {
        _arguments = new HashMap<>();
        for (int index = 0; index < args.length; index += 2) {
            if (args[index].startsWith(ARGUMENT_PREFIX))
                _arguments.put(args[index].trim().replace(ARGUMENT_PREFIX, ""), args[index + 1]);
            else
                throw new CliException(ARGUMENT_FORMAT_ERROR_MESSAGE);
        }
    }

    public static JSoundRuntimeConfiguration createJSoundRuntimeConfiguration(String[] args) {
        if (instance == null) {
            instance = new JSoundRuntimeConfiguration(args);
        }
        return instance;
    }

    public static JSoundRuntimeConfiguration getInstance() {
        return instance;
    }

    public String getOutputPath() {
        return this._arguments.getOrDefault("output", null);
    }

    public String getFile() {
        return this._arguments.getOrDefault("file", null);
    }

    public String getSchema() {
        return this._arguments.getOrDefault("schema", null);
    }

    public String getRootType() {
        return this._arguments.getOrDefault("root", null);
    }

    public boolean isCompact() {
        return Boolean.parseBoolean(this._arguments.getOrDefault("compact", null));
    }

    public boolean isValidate() {
        return Boolean.parseBoolean(this._arguments.getOrDefault("validate", null));
    }

    public boolean isAnnotate() {
        return Boolean.parseBoolean(this._arguments.getOrDefault("annotate", null));
    }

    public void hasNecessaryArguments() {
        if (getSchema() == null)
            throw new CliException("Missing schema argument");
        if (getFile() == null)
            throw new CliException("Missing instance file argument");
        if (getRootType() == null)
            throw new CliException("Missing type to validate the instance file against.");
    }
}
