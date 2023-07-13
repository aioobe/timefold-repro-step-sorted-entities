package testschedules;


import ai.timefold.solver.core.api.score.director.ScoreDirector;
import ai.timefold.solver.core.impl.heuristic.selector.common.decorator.SelectionSorter;

import java.util.Comparator;
import java.util.List;

public class LectureDifficultySorter implements SelectionSorter<Schedule, Lecture> {
    @Override
    public void sort(ScoreDirector<Schedule> scoreDirector, List<Lecture> selectionList) {
        // Dummy sort
        selectionList.sort(Comparator.comparing(Lecture::getLectureId));
    }
}
