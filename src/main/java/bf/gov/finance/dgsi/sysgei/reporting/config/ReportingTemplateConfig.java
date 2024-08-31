/*
 * Copyright (c) 2023 Mohamskab
 */

package bf.gov.finance.dgsi.sysgei.reporting.config;

import bf.gov.finance.dgsi.sysgei.domain.enumm.EReportType;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.AbstractMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
public class ReportingTemplateConfig {
    private static final String REPORT_ROOT = "reports/";
    private static final String DUMMY = REPORT_ROOT.concat("dummy.jasper");
    private static final String PREVISION_REPORT = REPORT_ROOT.concat("previsionReport.jasper");

    /**
     * Building a rest template instance.
     *
     * @return {@link ReportingTemplate}
     */
    @Bean
    public ReportingTemplate configure() {
        Map<String, String> map = Stream.of(
                new AbstractMap.SimpleImmutableEntry<>(EReportType.DUMMY.name(), DUMMY),
                new AbstractMap.SimpleImmutableEntry<>(EReportType.PREVISION_REPORT.name(), PREVISION_REPORT)
        ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return new ReportingTemplate(map);
    }

    @Data
    @AllArgsConstructor
    public static class ReportingTemplate {
        private Map<String, String> templateMap;
    }
}
