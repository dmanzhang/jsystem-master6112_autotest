package org.jsystem.automationProj;

import java.util.ArrayList;

import systemobject.terminal.Prompt;
import jsystem.framework.system.SystemObjectImpl;

public class BuildStationUbuntuShell extends SystemObjectImpl {
	private String connectMode;
	private ShellConnectionImpl shellConnection;
	
	public BuildStationUbuntuShell() {
		// TODO Auto-generated constructor stub
	}
	
	public BuildStationUbuntuShell(String linkMode, String[] param, int port, String connectedPrompt) throws Exception{
		this();
		report.report("connection:" + " " + connectedPrompt + " " + linkMode + " " + port);
		connectMode = linkMode;
		
		if (connectMode.compareTo("SSH") == 0)
        {
            report.report("connect by SSH");
	        shellConnection = new RawUbuntuSSHCliConnection(param[0], param[1], param[2]);
	         	
	        shellConnection.init();
        }
		else if (connectMode.compareTo("RAWSSH") == 0)
        {
            report.report("connect by raw SSH");
	        shellConnection = new RawUbuntuSSHCliConnection(param[0], param[1], param[2]);
			ArrayList<Prompt> prompts = new ArrayList<Prompt>();
	        Prompt p = new Prompt();
	        p.setPrompt("login:");
			p.setStringToSend("user");
			prompts.add(p);
			p = new Prompt();
			p.setPrompt("~$");
			p.setCommandEnd(true);
			prompts.add(p);
			shellConnection.setPrompts(prompts.toArray(new Prompt[prompts.size()]));
			shellConnection.init(); 
        }
		else if (connectMode.compareTo("RAWSSHwP") == 0)
        {
            report.report("connect by raw SSH with port");
	        shellConnection = new RawUbuntuSSHCliConnection(param[0], param[1], param[2], port);
			ArrayList<Prompt> prompts = new ArrayList<Prompt>();
	        Prompt p = new Prompt();
	        p.setPrompt("login:");
			p.setStringToSend("user");
			prompts.add(p);
			p = new Prompt();
			p.setPrompt("~$");
			p.setCommandEnd(true);
			prompts.add(p);
			shellConnection.setPrompts(prompts.toArray(new Prompt[prompts.size()]));
			shellConnection.init(); 
        }
		else if (connectMode.compareTo("RAWSSH2wP") == 0)
        {
            report.report("connect by raw SSH2 with port");
	        shellConnection = new RawUbuntuSSHCliConnection(param[0], param[1], param[2], port, true);
			ArrayList<Prompt> prompts = new ArrayList<Prompt>();
	        Prompt p = new Prompt();
	        p.setPrompt("login:");
			p.setStringToSend("user");
			prompts.add(p);
			p = new Prompt();
			p.setPrompt("~$");
			p.setCommandEnd(true);
			prompts.add(p);
			shellConnection.setPrompts(prompts.toArray(new Prompt[prompts.size()]));
			shellConnection.init(); 
        }
	}
	
	public BuildStationUbuntuShell(String linkMode, String[] param, int port, String connectedPrompt, String publickeyFile) throws Exception{
		this();
		report.report("connection:" + " " + connectedPrompt + " " + linkMode + " " + port);
		connectMode = linkMode;
		
		if (connectMode.compareTo("RAWSSHisRsa") == 0)
        {
            report.report("connect by raw RAWSSHisRsa");
	        shellConnection = new RawUbuntuSSHCliConnection(param[0], param[1], param[2], port, true, publickeyFile);
			ArrayList<Prompt> prompts = new ArrayList<Prompt>();
	        Prompt p = new Prompt();
	        p.setPrompt("publickey:");
			p.setStringToSend("yes");
			prompts.add(p);
			p = new Prompt();
	        p.setPrompt("login:");
			p.setStringToSend("user");
			prompts.add(p);
			p = new Prompt();
			p.setPrompt("~$");
			p.setCommandEnd(true);
			prompts.add(p);
			shellConnection.setPrompts(prompts.toArray(new Prompt[prompts.size()]));
			shellConnection.init(); 
        }
		else if (connectMode.compareTo("RAWSSH2isRsa") == 0)
        {
            report.report("connect by raw RAWSSHisRsa");
	        shellConnection = new RawUbuntuSSHCliConnection(param[0], param[1], param[2], port, true, publickeyFile, true);
			ArrayList<Prompt> prompts = new ArrayList<Prompt>();
	        Prompt p = new Prompt();
	        p.setPrompt("publickey:");
			p.setStringToSend("yes");
			prompts.add(p);
			p = new Prompt();
	        p.setPrompt("login:");
			p.setStringToSend("user");
			prompts.add(p);
			p = new Prompt();
			p.setPrompt("~$");
			p.setCommandEnd(true);
			prompts.add(p);
			shellConnection.setPrompts(prompts.toArray(new Prompt[prompts.size()]));
			shellConnection.init(); 
        }
		else if (connectMode.compareTo("RAWSSHwP") == 0)
        {
            report.report("connect by raw SSH with port");
	        shellConnection = new RawUbuntuSSHCliConnection(param[0], param[1], param[2], port);
			ArrayList<Prompt> prompts = new ArrayList<Prompt>();
	        Prompt p = new Prompt();
	        p.setPrompt("login:");
			p.setStringToSend("user");
			prompts.add(p);
			p = new Prompt();
			p.setPrompt("~$");
			p.setCommandEnd(true);
			prompts.add(p);
			shellConnection.setPrompts(prompts.toArray(new Prompt[prompts.size()]));
			shellConnection.init(); 
        }
		else if (connectMode.compareTo("RAWSSH2wP") == 0)
        {
            report.report("connect by raw SSH2 with port");
	        shellConnection = new RawUbuntuSSHCliConnection(param[0], param[1], param[2], port, true);
			ArrayList<Prompt> prompts = new ArrayList<Prompt>();
	        Prompt p = new Prompt();
	        p.setPrompt("login:");
			p.setStringToSend("user");
			prompts.add(p);
			p = new Prompt();
			p.setPrompt("~$");
			p.setCommandEnd(true);
			prompts.add(p);
			shellConnection.setPrompts(prompts.toArray(new Prompt[prompts.size()]));
			shellConnection.init(); 
        }
	}
	
	public void init() throws Exception {
        super.init();
        report.report("In init method");
        //shellConnection.init();
    }
	
    public void close(){
        report.report("In close method");
        super.close();
	}
    
    public Object clone() throws CloneNotSupportedException {
    	return super.clone();
    }
	
    public void rawCommand(String rawCommand, String prompt) 
        throws Exception {
    	RawCliCommand command = 
	        new RawCliCommand(rawCommand);
	    command.setPromptString(prompt);
        shellConnection.handleCliCommand(rawCommand, command);
        setTestAgainstObject(command.getResult());
	}

	public void rawCommandNoTimeOut(String rawCommand, String prompt) 
	        throws Exception {
		RawCliCommand command = 
		        new RawCliCommand(rawCommand);
		    command.setPromptString(prompt);
		    command.setTimeout(2*3600*1000);
		    shellConnection.handleCliCommand(rawCommand, command);

	        setTestAgainstObject(command.getResult());
	}
	
	public void rawCommand(String rawCommand, String prompt, boolean rawTest) 
	        throws Exception {
		    RawCliCommand command = 
		        new RawCliCommand(rawCommand);
		    command.setPromptString(prompt);
		    shellConnection.handleCliCommand(rawCommand, command);
	        setTestAgainstObject(command.getResult());
	}

	public void rawCommandNoTimeOut(String rawCommand, String prompt, boolean rawTest) 
		        throws Exception {
		        RawCliCommand command = 
			        new RawCliCommand(rawCommand);
			    command.setPromptString(prompt);
			    command.setTimeout(2*3600*1000);
			    shellConnection.handleCliCommand(rawCommand, command);

		        setTestAgainstObject(command.getResult());
	}
}
