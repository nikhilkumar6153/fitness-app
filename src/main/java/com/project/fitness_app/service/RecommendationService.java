package com.project.fitness_app.service;

import com.project.fitness_app.dto.RecommendationDTO;
import com.project.fitness_app.model.Activity;
import com.project.fitness_app.model.Recommendation;
import com.project.fitness_app.model.User;
import com.project.fitness_app.repository.RecommendationRepository;
import com.project.fitness_app.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecommendationService {

    private final RecommendationRepository recommendationRepository;
    private final UserRepository userRepository;

    public RecommendationService(RecommendationRepository recommendationRepository, UserRepository userRepository) {
        this.recommendationRepository = recommendationRepository;
        this.userRepository = userRepository;
    }

    // Generate recommendations automatically based on activity
    public Recommendation generateRecommendation(User user, Activity activity) {
        List<String> improvements = new ArrayList<>();
        List<String> suggestions = new ArrayList<>();
        List<String> safety = new ArrayList<>();

        // Simple example logic
        switch (activity.getType()) {
            case RUNNING -> {
                improvements.add("Increase pace gradually.");
                suggestions.add("Include stretching before running.");
                safety.add("Wear proper running shoes.");
            }
            case YOGA -> {
                improvements.add("Hold poses for longer periods.");
                suggestions.add("Focus on breathing techniques.");
                safety.add("Avoid pushing yourself too hard.");
            }
            case WEIGHT_TRAINING -> {
                improvements.add("Gradually increase weights.");
                suggestions.add("Maintain correct posture.");
                safety.add("Use spotter for heavy lifts.");
            }
            default -> {
                improvements.add("Stay consistent.");
                suggestions.add("Track your progress.");
                safety.add("Listen to your body.");
            }
        }

        Recommendation recommendation = Recommendation.builder()
                .user(user)
                .activity(activity)
                .type(activity.getType().name())
                .recommendation("Personalized recommendation based on your activity.")
                .improvements(improvements)
                .suggestions(suggestions)
                .safety(safety)
                .build();

        return recommendationRepository.save(recommendation);
    }

    public List<RecommendationDTO> getRecommendationsByUser(String userId) {
        List<Recommendation> recommendations = recommendationRepository.findByUserId(userId);
        List<RecommendationDTO> dtos = new ArrayList<>();
        for (Recommendation r : recommendations) {
            dtos.add(mapToDTO(r));
        }
        return dtos;
    }

    public RecommendationDTO mapToDTO(Recommendation recommendation) {
        return RecommendationDTO.builder()
                .id(recommendation.getId())
                .userId(recommendation.getUser().getId())
                .activityId(recommendation.getActivity().getId())
                .type(recommendation.getType())
                .recommendation(recommendation.getRecommendation())
                .improvements(recommendation.getImprovements())
                .suggestions(recommendation.getSuggestions())
                .safety(recommendation.getSafety())
                .build();
    }
}
