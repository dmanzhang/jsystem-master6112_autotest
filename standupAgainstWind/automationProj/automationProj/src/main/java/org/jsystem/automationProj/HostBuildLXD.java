package org.jsystem.automationProj;

import java.util.ArrayList;

import jsystem.extensions.analyzers.text.FindText;

import org.jsystem.automationProj.BuildStationParam;
import org.jsystem.automationProj.BuildStationUbuntuShell;
import org.junit.Before;
import org.junit.Test;

import junit.framework.SystemTestCase4;

public class HostBuildLXD extends SystemTestCase4 {
	private BuildStationParam testParam;	
	private static BuildStationUbuntuShell myStation;
	
	@Before
	public void before() throws Exception{
		report.report("Before operation");
		testParam =  
	              (BuildStationParam)system.getSystemObject("buildLXD_shell");
		
	}

	@Test
	public void OpenDUT() throws Exception {
		report.report("Calling operation");
		ArrayList <String>inparams = new ArrayList<String>();
		if (testParam.getConnectMode().compareTo("SSH") == 0)
        {
            inparams.add(testParam.getHost());
			inparams.add(testParam.getUserName());
			inparams.add(testParam.getPassword());
			myStation = new BuildStationUbuntuShell(testParam.getConnectMode(), inparams.toArray(new String[inparams.size()]),
				                              testParam.getSshPort(), testParam.getConnectedPrompt());
        }
		else if (testParam.getConnectMode().compareTo("RAWSSH") == 0)
        {
            inparams.add(testParam.getHost());
			inparams.add(testParam.getUserName());
			inparams.add(testParam.getPassword());
			myStation = new BuildStationUbuntuShell(testParam.getConnectMode(), inparams.toArray(new String[inparams.size()]),
				                              testParam.getSshPort(), testParam.getConnectedPrompt());
        }
		else if (testParam.getConnectMode().compareTo("RAWSSHwP") == 0)
        {
            inparams.add(testParam.getHost());
			inparams.add(testParam.getUserName());
			inparams.add(testParam.getPassword());
			myStation = new BuildStationUbuntuShell(testParam.getConnectMode(), inparams.toArray(new String[inparams.size()]),
				                              testParam.getSshPort(), testParam.getConnectedPrompt());
        }
		else if (testParam.getConnectMode().compareTo("RAWSSH2wP") == 0)
        {
            inparams.add(testParam.getHost());
			inparams.add(testParam.getUserName());
			inparams.add(testParam.getPassword());
			myStation = new BuildStationUbuntuShell(testParam.getConnectMode(), inparams.toArray(new String[inparams.size()]),
				                              testParam.getSshPort(), testParam.getConnectedPrompt());
        }
		else if (testParam.getConnectMode().compareTo("RAWSSHisRsa") == 0)
        {
            inparams.add(testParam.getHost());
			inparams.add(testParam.getUserName());
			inparams.add(testParam.getPassword());
			myStation = new BuildStationUbuntuShell(testParam.getConnectMode(), inparams.toArray(new String[inparams.size()]),
				                              testParam.getSshPort(), testParam.getConnectedPrompt(), testParam.getPublickeyFile());
        }
		else if (testParam.getConnectMode().compareTo("RAWSSH2isRsa") == 0)
        {
            inparams.add(testParam.getHost());
			inparams.add(testParam.getUserName());
			inparams.add(testParam.getPassword());
			myStation = new BuildStationUbuntuShell(testParam.getConnectMode(), inparams.toArray(new String[inparams.size()]),
				                              testParam.getSshPort(), testParam.getConnectedPrompt(), testParam.getPublickeyFile());
        }
		else
		{
		    return;
		}

		myStation.init();
		myStation.rawCommand("ls", testParam.getConnectedPrompt(), true); 
	}

	@Test
	public void enterAospBuildView() throws Exception {
		report.report("enter view " + testParam.getAospView());
		myStation.rawCommand("cd " + testParam.getAospView(), testParam.getPromptString());
	}

	@Test
	public void buildAospCommon() throws Exception {
		report.report("make");
		myStation.rawCommand("source build/envsetup.sh", testParam.getPromptString());
		myStation.rawCommand("lunch " + testParam.getAospProduct(), testParam.getPromptString());
		myStation.rawCommandNoTimeOut("make -j8", testParam.getPromptString());
		myStation.analyze(new FindText(testParam.getStripAospOk()));
	}
	
	@Test
	public void cleanAospCommon() throws Exception {
		report.report("make clean");
		myStation.rawCommandNoTimeOut("make clean", testParam.getStripAospOk());
	}
	
	@Test
	public void repoSync() throws Exception {
		report.report("repo sync");
		myStation.rawCommandNoTimeOut("repo sync", testParam.getStripAospOk());
	}
	
	@Test
	public void enterEmulatorBuildView() throws Exception {
		report.report("enter view " + testParam.getEmulatorView());
		myStation.rawCommand("cd " + testParam.getEmulatorView(), testParam.getPromptString());
	}
	
	@Test
	public void buildEmulatorCommon() throws Exception {
		report.report("make");
		myStation.rawCommandNoTimeOut("external/qemu/andriod/rebuild.sh", testParam.getPromptString());
		myStation.analyze(new FindText(testParam.getStripEmulatorOk()));
	}
	
	@Test
	public void cleanEmulatorCommon() throws Exception {
		report.report("make clean");
		myStation.rawCommandNoTimeOut("make clean", testParam.getPromptString());
	}
	
	@Test
	public void enterKernelBuildView() throws Exception {
		report.report("enter view " + testParam.getKernelView());
		myStation.rawCommand("cd " + testParam.getKernelView(), testParam.getPromptString());
	}
	
	@Test
	public void buildKernelBuildCommon() throws Exception {
		report.report("make");
		myStation.rawCommand("export BUILD_CONFIG=goldfish/build.config.eswin.riscv64" + testParam.getAospProduct(), testParam.getPromptString());
		myStation.rawCommandNoTimeOut("./build/build.sh", testParam.getPromptString());
		myStation.analyze(new FindText(testParam.getStripKernelOk()));
	}
	
	@Test
	public void cleanKernelBuildCommon() throws Exception {
		report.report("make clean");
		myStation.rawCommandNoTimeOut("make clean", testParam.getPromptString());
	}
	
	@Test
	public void enterQemuBuildView() throws Exception {
		report.report("enter view " + testParam.getQemuView());
		myStation.rawCommand("cd " + testParam.getQemuView(), testParam.getPromptString());
	}
	
	@Test
	public void buildQemuCommon() throws Exception {
		report.report("make");
		myStation.rawCommandNoTimeOut("make", testParam.getPromptString());
		myStation.analyze(new FindText(testParam.getStripQemuOk()));
	}
	
	@Test
	public void cleanQemuCommon() throws Exception {
		report.report("make clean");
		myStation.rawCommandNoTimeOut("make clean", testParam.getPromptString());
	}
	
}
