package com.tcs.Repo.Controller;

import java.util.Comparator;

import com.tcs.Repo.model.ProjectionVO;

public class ProjectionCompartor implements Comparator<ProjectionVO>
{
    public int compare(ProjectionVO c1, ProjectionVO c2)
    {
        return c1.getProject().compareTo(c2.getProject());
    }
}
