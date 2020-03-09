package lab;

import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.NlpAnalysis;

import java.util.List;

public class 分词Demo {
    public static void main(String[] args) {
        String sentence = "中国人";
        List<Term> termList =  NlpAnalysis.parse(sentence).getTerms();
        for(Term term : termList){
            System.out.println(term.getNatureStr()+":"+term.getRealName());
        }
    }
}
