package write.clean.domain.Problem;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import write.clean.domain.Answer.Answer;
import write.clean.domain.User.User;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "problem")
public class Problem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long problem_id;

    @Column(name = "content")
    private String problemContent;

    @OneToMany(mappedBy = "problem")
    private List<Answer> answers = new ArrayList<>();

    @ManyToOne
    private User user;

    public void addAnswer(Answer answer) {
        this.answers.add(answer);
    }

    @Builder
    public Problem(String problemContent) {
        this.problemContent = problemContent;
    }
}
