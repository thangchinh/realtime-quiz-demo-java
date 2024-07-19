package com.example.realtime_quiz_demo.event;

import com.example.realtime_quiz_demo.model.LeaderBoard;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePointEvent {
    private LeaderBoard leaderBoard;
}