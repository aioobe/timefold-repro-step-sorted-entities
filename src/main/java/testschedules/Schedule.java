package testschedules;


import ai.timefold.solver.core.api.domain.solution.PlanningEntityCollectionProperty;
import ai.timefold.solver.core.api.domain.solution.PlanningScore;
import ai.timefold.solver.core.api.domain.solution.PlanningSolution;
import ai.timefold.solver.core.api.domain.solution.ProblemFactCollectionProperty;
import ai.timefold.solver.core.api.domain.valuerange.ValueRangeProvider;
import ai.timefold.solver.core.api.score.buildin.hardsoft.HardSoftScore;

import java.util.List;

@PlanningSolution
public class Schedule {

    @PlanningEntityCollectionProperty
    private List<Lecture> lectures;

    @ValueRangeProvider(id = "timeslotRange")
    @ProblemFactCollectionProperty
    private List<Integer> timeslots;

    @PlanningScore
    private HardSoftScore score;

    public Schedule() {
    }

    public Schedule(List<Lecture> lectures, List<Integer> timeslots) {
        this.lectures = lectures;
        this.timeslots = timeslots;
    }
}
