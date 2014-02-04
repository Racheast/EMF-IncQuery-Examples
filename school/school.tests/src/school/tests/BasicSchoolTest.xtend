/*******************************************************************************
 * Copyright (c) 2010-2012, Abel Hegedus, Istvan Rath and Daniel Varro
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Abel Hegedus - initial API and implementation
 *   Istvan Rath - extensions, first real test set
 *******************************************************************************/

package school.tests

import com.google.inject.Inject
import org.eclipse.incquery.runtime.api.AdvancedIncQueryEngine
import org.eclipse.incquery.testing.core.SnapshotHelper
import org.eclipse.incquery.testing.core.TestExecutor
import org.eclipse.incquery.testing.core.injector.EMFPatternLanguageInjectorProvider
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith
import school.util.ClassesOfTeacherQuerySpecification
import school.util.CourseWithNameLongerThanWeightQuerySpecification
import school.util.CourseWithPrimeWeightQuerySpecification
import school.util.CourseWithWeightThirtyQuerySpecification
import school.util.CoursesOfTeacherQuerySpecification
import school.util.FinalPatternQuerySpecification
import school.util.FriendlyToQuerySpecification
import school.util.InTheCircleOfFriendsQuerySpecification
import school.util.MoreFriendsThanQuerySpecification
import school.util.SchoolsQuerySpecification
import school.util.StudentOfSchoolQuerySpecification
import school.util.TeacherWithoutClassQuerySpecification
import school.util.TeachersOfSchoolQuerySpecification
import school.util.TeachersQuerySpecification
import school.util.TeachesMoreClassesQuerySpecification
import school.util.TeachesTheMostCoursesQuerySpecification
import school.util.TheOnesWithTheBiggestCircleQuerySpecification

/**
 * Basic test set for testing IncQuery with the school example.
 * These tests just perform a simple match set check against all the queries in the School example.
 * See https://viatra.inf.mit.bme.hu/incquery/new/examples/school for details on the example.
 * @author Istvan Rath
 */
@RunWith(typeof(XtextRunner))
@InjectWith(typeof(EMFPatternLanguageInjectorProvider))
class BasicSchoolTest extends SchoolTestsBase {
	
	@Inject extension SnapshotHelper
	@Inject extension TestExecutor
	
	// parse pattern from URI, load expected from URI, assertMatchResults, CORRECT
	@Test
	def testAllQueriesXMI(){
		assertMatchResults(queryInputXMI, snapshot)
	}
	
	// parse pattern from EIQ, load expected from URI, assertMatchResults, CORRECT
	@Test@Ignore("Not working on the build as eiq files are not packaged into jar.")
	def testAllQueriesEIQ(){
		assertMatchResults(queryInputEIQ, snapshot)
	}
			
	// simple test cases, for each query of the school example
	 
	@Test def testSchools() { testQuery("school.schools") }
	@Test def testTeachers() { testQuery("school.teachers") }
	@Test def testTeachersOfSchool() { testQuery("school.teachersOfSchool") }
	@Test def testCoursesOfTeacher() { testQuery("school.coursesOfTeacher") }
	@Test def testClassesOfTeacher() { testQuery("school.classesOfTeacher") }
	@Test def testTeacherWithoutClass() { testQuery("school.teacherWithoutClass") }
	@Test def testStudentOfSchool() { testQuery("school.studentOfSchool") }
	@Test def testCourseWithWeightThirty() { testQuery("school.courseWithWeightThirty") }
	@Test def testCourseWithNameLongerThanWeight() { testQuery("school.courseWithNameLongerThanWeight") }
	@Test def testCourseWithPrimeWeight() { testQuery("school.courseWithPrimeWeight") }
	@Test def testTeachesMoreClasses() { testQuery("school.teachesMoreClasses") }
	@Test def testTeachesTheMostCourses() { testQuery("school.teachesTheMostCourses") }
	@Test def testFriendlyTo() { testQuery("school.friendlyTo") }
	@Test def testInTheCircleOfFriends() { testQuery("school.inTheCircleOfFriends") }
	@Test def testMoreFriendsThan() { testQuery("school.moreFriendsThan") }
	@Test def testTheOnesWithTheBiggestCircle() { testQuery("school.theOnesWithTheBiggestCircle") }
	@Test def testFinalPattern() { testQuery("school.finalPattern") }	
	
	@Test def mfTestSchools() { testQuery(SchoolsQuerySpecification::instance) }
	@Test def mfTestTeachers() { testQuery(TeachersQuerySpecification::instance) }
	@Test def mfTestTeachersOfSchool() { testQuery(TeachersOfSchoolQuerySpecification::instance) }
	@Test def mfTestCoursesOfTeacher() { testQuery(CoursesOfTeacherQuerySpecification::instance) }
	@Test def mfTestClassesOfTeacher() { testQuery(ClassesOfTeacherQuerySpecification::instance) }
	@Test def mfTestTeacherWithoutClass() { testQuery(TeacherWithoutClassQuerySpecification::instance) }
	@Test def mfTestStudentOfSchool() { testQuery(StudentOfSchoolQuerySpecification::instance) }
	@Test def mfTestCourseWithWeightThirty() { testQuery(CourseWithWeightThirtyQuerySpecification::instance) }
	@Test def mfTestCourseWithNameLongerThanWeight() { testQuery(CourseWithNameLongerThanWeightQuerySpecification::instance) }
	@Test def mfTestCourseWithPrimeWeight() { testQuery(CourseWithPrimeWeightQuerySpecification::instance) }
	@Test def mfTestTeachesMoreClasses() { testQuery(TeachesMoreClassesQuerySpecification::instance) }
	@Test def mfTestTeachesTheMostCourses() { testQuery(TeachesTheMostCoursesQuerySpecification::instance) }
	@Test def mfTestFriendlyTo() { testQuery(FriendlyToQuerySpecification::instance) }
	@Test def mfTestInTheCircleOfFriends() { testQuery(InTheCircleOfFriendsQuerySpecification::instance) }
	@Test def mfTestMoreFriendsThan() { testQuery(MoreFriendsThanQuerySpecification::instance) }
	@Test def mfTestTheOnesWithTheBiggestCircle() { testQuery(TheOnesWithTheBiggestCircleQuerySpecification::instance) }
	@Test def mfTestFinalPattern() { testQuery(FinalPatternQuerySpecification::instance) }	
	
	@Test
	def wildcardTestFinalPattern(){
    	val sns = snapshot
    	val engine = AdvancedIncQueryEngine::createUnmanagedEngine(sns.EMFRootForSnapshot, true)
    	engine.testQuery(sns, FinalPatternQuerySpecification::instance)
	}
	
}