package ch09.디버깅;

import java.util.Arrays;
import java.util.List;

import ch09.람다테스팅.Point;

public class Debugging {

	public static void main(String[] args) {
		List<Point> points = Arrays.asList(new Point(5, 5), null);
		points.stream()
			.map(p -> p.getX())
			.forEach(System.out::println);
		/* 람다의 스택 트레이스는 이해하기 어렵다
		Exception in thread "main" java.lang.NullPointerException
			at ch09.디버깅.Debugging.lambda$main$0(Debugging.java:13)
			at java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:195)
			at java.base/java.util.Spliterators$ArraySpliterator.forEachRemaining(Spliterators.java:948)
			at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:484)
			at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
			at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
			at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
			at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
			at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
			at ch09.디버깅.Debugging.main(Debugging.java:14)
		 */
	}

}
