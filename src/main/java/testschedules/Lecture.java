package testschedules;


import ai.timefold.solver.core.api.domain.entity.PlanningEntity;
import ai.timefold.solver.core.api.domain.lookup.PlanningId;
import ai.timefold.solver.core.api.domain.variable.PlanningVariable;

@PlanningEntity
public class Lecture {

    @PlanningId
    private int lectureId;

    @PlanningVariable(valueRangeProviderRefs = "timeslotRange", nullable = true)
    private Integer startTimeslot;

    public Lecture() {
    }

    public Lecture(int lectureId) {
        this.lectureId = lectureId;
    }

    public int getLectureId() {
        return lectureId;
    }

    public boolean isScheduled() {
        return startTimeslot != null;
    }
}
