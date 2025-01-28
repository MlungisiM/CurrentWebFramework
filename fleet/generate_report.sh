#!/bin/bash

# Define paths
TEMPLATE_PATH="reports/reportTemplate.html"  # Path to your report template
SUMMARY_PATH="reports/TestSummary.txt"      # Path to your summary file
FINAL_REPORT_PATH="reports/TestSummary.html" # Path to your final report

# Initialize variables for summary values
TOTAL_TESTS=0
PASSED=0
FAILED=0
SKIPPED=0
EXECUTION_DATE=""

# Read the summary file and extract values
if [[ -f $SUMMARY_PATH ]]; then
    echo "Reading summary from $SUMMARY_PATH"
    while IFS='=' read -r key value; do
        case $key in
            total_tests)
                TOTAL_TESTS="$value"
                ;;
            passed)
                PASSED="$value"
                ;;
            failed)
                FAILED="$value"
                ;;
            skipped)
                SKIPPED="$value"
                ;;
            execution_date)
                EXECUTION_DATE="$value"
                ;;
        esac
    done < "$SUMMARY_PATH"

    # If EXECUTION_DATE was not found in the summary, set it to the current date/time
    if [[ -z $EXECUTION_DATE ]]; then
        EXECUTION_DATE=$(date +"%Y-%m-%d %I:%M %p")
    fi
else
    echo "Summary file not found: $SUMMARY_PATH"
    exit 1
fi

# Generate the final report
if [[ -f $TEMPLATE_PATH ]]; then
    cp "$TEMPLATE_PATH" "$FINAL_REPORT_PATH"

    # Replace placeholders in the final report
    sed -i "s/{{TOTAL_TESTS}}/$TOTAL_TESTS/g" "$FINAL_REPORT_PATH"
    sed -i "s/{{PASSED}}/$PASSED/g" "$FINAL_REPORT_PATH"
    sed -i "s/{{FAILED}}/$FAILED/g" "$FINAL_REPORT_PATH"
    sed -i "s/{{SKIPPED}}/$SKIPPED/g" "$FINAL_REPORT_PATH"
    sed -i "s/{{EXECUTION_DATE}}/$EXECUTION_DATE/g" "$FINAL_REPORT_PATH"

    echo "Final report generated at: $FINAL_REPORT_PATH"
else
    echo "Report template not found: $TEMPLATE_PATH"
    exit 1
fi
