package org.jsystem.automationProj;

import systemobject.terminal.Prompt;

import java.io.File;
import java.util.ArrayList;

import systemobject.terminal.VT100FilterInputStream;

import com.aqua.sysobj.conn.Position;

public class RawSSHCliConnection extends ShellConnectionImpl {
	
	public RawSSHCliConnection(){
		setDump(true);
		setUseTelnetInputStream(true);
		setProtocol("ssh");
		setPort(22);
	}

	public RawSSHCliConnection(String host,String user,String password){
		super();
		setUser(user);
		setPassword(password);
		setHost(host);
	}
	
	public RawSSHCliConnection(String host,String user,String password, boolean isRsa, String publickeyFile){
		super();
		
		File privateKeyFile = new File(publickeyFile);
		setUser(user);
		setPassword(password);
		if (isRsa)
		{
			setProtocol("ssh-rsa");
			setPrivateKey(privateKeyFile);
		}
		else
		{
			setProtocol("ssh");
		}
		setHost(host);
	}
	
	public RawSSHCliConnection(String host,String user,String password, int port){
		super();
		setUser(user);
		setPassword(password);
		setHost(host);
		setProtocol("ssh");
		setPort(port);
	}
	
	public RawSSHCliConnection(String host,String user,String password, int port, boolean isRsa, String publickeyFile){
		super();
		
		File privateKeyFile = new File(publickeyFile);
		setUser(user);
		setPassword(password);
		setHost(host);
		if (isRsa)
		{
			setProtocol("ssh-rsa");
			setPrivateKey(privateKeyFile);
		}
		else
		{
			setProtocol("ssh");
		}
		setPort(port);
	}
	
	@Override
	public void init() throws Exception {
		super.init();
	}
	
	@Override
	public void connect() throws Exception {
		super.connect();
		terminal.addFilter(new VT100FilterInputStream());
	}
	
	public Position[] getPositions() {
		// TODO Auto-generated method stub
		return null;
	}

	public Prompt[] getPrompts() {
		ArrayList<Prompt> prompts = new ArrayList<Prompt>();		
		Prompt p = new Prompt();
		p.setCommandEnd(true);
		p.setPrompt("# ");
		prompts.add(p);

		p = new Prompt();
		p.setPrompt("login: ");
		p.setStringToSend(getUser());
		prompts.add(p);

		p = new Prompt();
		p.setPrompt("Password: ");
		p.setStringToSend(getPassword());
		prompts.add(p);
		return prompts.toArray(new Prompt[prompts.size()]);
	}

}


