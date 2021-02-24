package com.cattelecom.incidentReport.Service;

import java.util.List;
import java.util.Map;

import com.cattelecom.incidentReport.Model.Entry;
import com.cattelecom.incidentReport.Model.Status;

public interface EntryServiceImpl {
    public Map<Status, List<Entry>> getGroupedEntries();
}
