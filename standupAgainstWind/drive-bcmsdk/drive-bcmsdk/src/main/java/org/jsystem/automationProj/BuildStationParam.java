package org.jsystem.automationProj;

import jsystem.framework.system.SystemObjectImpl;

public class BuildStationParam extends SystemObjectImpl {
	private String host;
    private String userName;
    private String password;
    private int sshPort;
    private String promptString;
    private String connectedPrompt;
    private String publickeyFile;
    
    private String aospView;
    private String emulatorView;
    private String kernelView;
    private String qemuView;
    private String stripAospOk;
    private String stripEmulatorOk;
    private String stripKernelOk;
    private String stripQemuOk;    
    
    private String aospProduct;
    
    private String connectMode;
    
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getSshPort() {
		return sshPort;
	}
	public void setSshPort(int sshPort) {
		this.sshPort = sshPort;
	}
	public String getPromptString() {
		return promptString;
	}
	public void setPromptString(String promptString) {
		this.promptString = promptString;
	}
	public String getConnectedPrompt() {
		return connectedPrompt;
	}
	public void setConnectedPrompt(String connectedPrompt) {
		this.connectedPrompt = connectedPrompt;
	}
	public String getAospView() {
		return aospView;
	}
	public void setAospView(String aospView) {
		this.aospView = aospView;
	}
	public String getEmulatorView() {
		return emulatorView;
	}
	public void setEmulatorView(String emulatorView) {
		this.emulatorView = emulatorView;
	}
	public String getKernelView() {
		return kernelView;
	}
	public void setKernelView(String kernelView) {
		this.kernelView = kernelView;
	}
	public String getQemuView() {
		return qemuView;
	}
	public void setQemuView(String qemuView) {
		this.qemuView = qemuView;
	}
	public String getStripAospOk() {
		return stripAospOk;
	}
	public void setStripAospOk(String stripAospOk) {
		this.stripAospOk = stripAospOk;
	}
	public String getStripEmulatorOk() {
		return stripEmulatorOk;
	}
	public void setStripEmulatorOk(String stripEmulatorOk) {
		this.stripEmulatorOk = stripEmulatorOk;
	}
	public String getStripKernelOk() {
		return stripKernelOk;
	}
	public void setStripKernelOk(String stripKernelOk) {
		this.stripKernelOk = stripKernelOk;
	}
	public String getStripQemuOk() {
		return stripQemuOk;
	}
	public void setStripQemuOk(String stripQemuOk) {
		this.stripQemuOk = stripQemuOk;
	}
	public String getConnectMode() {
		return connectMode;
	}
	public void setConnectMode(String connectMode) {
		this.connectMode = connectMode;
	}
	public String getAospProduct() {
		return aospProduct;
	}
	public void setAospProduct(String aospProduct) {
		this.aospProduct = aospProduct;
	}
	public String getPublickeyFile() {
		return publickeyFile;
	}
	public void setPublickeyFile(String publickeyFile) {
		this.publickeyFile = publickeyFile;
	}
    
}
