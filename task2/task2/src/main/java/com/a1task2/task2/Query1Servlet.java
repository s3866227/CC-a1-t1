package com.a1task2.task2;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.FieldValueList;
import com.google.cloud.bigquery.Job;
import com.google.cloud.bigquery.JobException;
import com.google.cloud.bigquery.JobId;
import com.google.cloud.bigquery.JobInfo;
import com.google.cloud.bigquery.QueryJobConfiguration;
import com.google.cloud.bigquery.TableResult;


@WebServlet("/index.jsp")
public class Query1Servlet extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
        

        String query = "SELECT time_ref, SUM(IF(account = 'Imports', value, 0)) + SUM(IF(account = 'Exports', value, 0))"+
        "AS trade_value FROM `task2.gsquarterlySeptember20` GROUP BY time_ref ORDER BY trade_value DESC LIMIT 10";

        QueryJobConfiguration queryConfig = QueryJobConfiguration.newBuilder(query).build();

        // Create a job ID so that we can safely retry.
        JobId jobId = JobId.of(UUID.randomUUID().toString());
        Job queryJob = bigquery.create(JobInfo.newBuilder(queryConfig).setJobId(jobId).build());

        // Wait for the query to complete.
        try {
            queryJob = queryJob.waitFor();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Check for errors
        if (queryJob == null) {
            throw new RuntimeException("Job no longer exists");
        } else if (queryJob.getStatus().getError() != null) {
        // You can also look at queryJob.getStatus().getExecutionErrors() for all
        // errors, not just the latest one.
            throw new RuntimeException(queryJob.getStatus().getError().toString());
        }

        try {
            TableResult result = bigquery.query(queryConfig);
            // Iterable<FieldValueList> timerefs = result.iterateAll();
            // request.setAttribute("task2-1", timerefs);

            // request.getRequestDispatcher("/index.jsp").forward(request, response);
        } catch (JobException | InterruptedException e) {
            // TODO Auto-generated catch block
            response.getWriter().println("error");
            e.printStackTrace();
        }
    }
}
