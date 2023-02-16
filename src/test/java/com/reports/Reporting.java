package com.reports;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.base.BaseClass;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Reporting extends BaseClass {
	/**
	 * @see This method is used to generate the JVM report after the execution is
	 *      complete
	 * @param jsonfile
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void generateJvmReport(String jsonfile) throws FileNotFoundException, IOException {
		File file = new File(getPropertyPath() + getPropertyFileValue("JvmPath"));

		Configuration configuration = new Configuration(file, "OMRBranchAutomation");
		configuration.addClassifications("Browser", "Chrome");
		configuration.addClassifications("Version", "108");
		configuration.addClassifications("OS", "Windows 10");
		configuration.addClassifications("Sprint", "34");

		List<String> jsonFiles = new ArrayList<String>();
		jsonFiles.add(jsonfile);
		ReportBuilder builder = new ReportBuilder(jsonFiles, configuration);

		builder.generateReports();

	}

}
