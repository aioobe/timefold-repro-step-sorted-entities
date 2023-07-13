package testschedules;


import ai.timefold.solver.core.api.score.stream.Constraint;
import ai.timefold.solver.core.api.score.stream.ConstraintFactory;
import ai.timefold.solver.core.api.score.stream.ConstraintProvider;
import ai.timefold.solver.core.api.score.stream.DefaultConstraintJustification;

import static ai.timefold.solver.core.api.score.buildin.hardsoft.HardSoftScore.ONE_HARD;

public class SchedulingConstraintProvider implements ConstraintProvider {

    @Override
    public Constraint[] defineConstraints(ConstraintFactory cf) {
        return new Constraint[] {
                unscheduledLectureConstraint(cf)
        };
    }

    private Constraint unscheduledLectureConstraint(ConstraintFactory cf) {
        return cf.forEachIncludingNullVars(Lecture.class)
                .filter(l1 -> !l1.isScheduled())
                .penalize(ONE_HARD)
                .justifyWith((l, s) -> DefaultConstraintJustification.of(s, l))
                .asConstraint("unscheduled-lecture");
    }
}
