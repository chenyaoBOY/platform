package com.frog.platform.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VisitPvExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VisitPvExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andDayVisitIsNull() {
            addCriterion("day_visit is null");
            return (Criteria) this;
        }

        public Criteria andDayVisitIsNotNull() {
            addCriterion("day_visit is not null");
            return (Criteria) this;
        }

        public Criteria andDayVisitEqualTo(Long value) {
            addCriterion("day_visit =", value, "dayVisit");
            return (Criteria) this;
        }

        public Criteria andDayVisitNotEqualTo(Long value) {
            addCriterion("day_visit <>", value, "dayVisit");
            return (Criteria) this;
        }

        public Criteria andDayVisitGreaterThan(Long value) {
            addCriterion("day_visit >", value, "dayVisit");
            return (Criteria) this;
        }

        public Criteria andDayVisitGreaterThanOrEqualTo(Long value) {
            addCriterion("day_visit >=", value, "dayVisit");
            return (Criteria) this;
        }

        public Criteria andDayVisitLessThan(Long value) {
            addCriterion("day_visit <", value, "dayVisit");
            return (Criteria) this;
        }

        public Criteria andDayVisitLessThanOrEqualTo(Long value) {
            addCriterion("day_visit <=", value, "dayVisit");
            return (Criteria) this;
        }

        public Criteria andDayVisitIn(List<Long> values) {
            addCriterion("day_visit in", values, "dayVisit");
            return (Criteria) this;
        }

        public Criteria andDayVisitNotIn(List<Long> values) {
            addCriterion("day_visit not in", values, "dayVisit");
            return (Criteria) this;
        }

        public Criteria andDayVisitBetween(Long value1, Long value2) {
            addCriterion("day_visit between", value1, value2, "dayVisit");
            return (Criteria) this;
        }

        public Criteria andDayVisitNotBetween(Long value1, Long value2) {
            addCriterion("day_visit not between", value1, value2, "dayVisit");
            return (Criteria) this;
        }

        public Criteria andDateVisitIsNull() {
            addCriterion("date_visit is null");
            return (Criteria) this;
        }

        public Criteria andDateVisitIsNotNull() {
            addCriterion("date_visit is not null");
            return (Criteria) this;
        }

        public Criteria andDateVisitEqualTo(Date value) {
            addCriterion("date_visit =", value, "dateVisit");
            return (Criteria) this;
        }

        public Criteria andDateVisitNotEqualTo(Date value) {
            addCriterion("date_visit <>", value, "dateVisit");
            return (Criteria) this;
        }

        public Criteria andDateVisitGreaterThan(Date value) {
            addCriterion("date_visit >", value, "dateVisit");
            return (Criteria) this;
        }

        public Criteria andDateVisitGreaterThanOrEqualTo(Date value) {
            addCriterion("date_visit >=", value, "dateVisit");
            return (Criteria) this;
        }

        public Criteria andDateVisitLessThan(Date value) {
            addCriterion("date_visit <", value, "dateVisit");
            return (Criteria) this;
        }

        public Criteria andDateVisitLessThanOrEqualTo(Date value) {
            addCriterion("date_visit <=", value, "dateVisit");
            return (Criteria) this;
        }

        public Criteria andDateVisitIn(List<Date> values) {
            addCriterion("date_visit in", values, "dateVisit");
            return (Criteria) this;
        }

        public Criteria andDateVisitNotIn(List<Date> values) {
            addCriterion("date_visit not in", values, "dateVisit");
            return (Criteria) this;
        }

        public Criteria andDateVisitBetween(Date value1, Date value2) {
            addCriterion("date_visit between", value1, value2, "dateVisit");
            return (Criteria) this;
        }

        public Criteria andDateVisitNotBetween(Date value1, Date value2) {
            addCriterion("date_visit not between", value1, value2, "dateVisit");
            return (Criteria) this;
        }

        public Criteria andTotalVisitIsNull() {
            addCriterion("total_visit is null");
            return (Criteria) this;
        }

        public Criteria andTotalVisitIsNotNull() {
            addCriterion("total_visit is not null");
            return (Criteria) this;
        }

        public Criteria andTotalVisitEqualTo(Long value) {
            addCriterion("total_visit =", value, "totalVisit");
            return (Criteria) this;
        }

        public Criteria andTotalVisitNotEqualTo(Long value) {
            addCriterion("total_visit <>", value, "totalVisit");
            return (Criteria) this;
        }

        public Criteria andTotalVisitGreaterThan(Long value) {
            addCriterion("total_visit >", value, "totalVisit");
            return (Criteria) this;
        }

        public Criteria andTotalVisitGreaterThanOrEqualTo(Long value) {
            addCriterion("total_visit >=", value, "totalVisit");
            return (Criteria) this;
        }

        public Criteria andTotalVisitLessThan(Long value) {
            addCriterion("total_visit <", value, "totalVisit");
            return (Criteria) this;
        }

        public Criteria andTotalVisitLessThanOrEqualTo(Long value) {
            addCriterion("total_visit <=", value, "totalVisit");
            return (Criteria) this;
        }

        public Criteria andTotalVisitIn(List<Long> values) {
            addCriterion("total_visit in", values, "totalVisit");
            return (Criteria) this;
        }

        public Criteria andTotalVisitNotIn(List<Long> values) {
            addCriterion("total_visit not in", values, "totalVisit");
            return (Criteria) this;
        }

        public Criteria andTotalVisitBetween(Long value1, Long value2) {
            addCriterion("total_visit between", value1, value2, "totalVisit");
            return (Criteria) this;
        }

        public Criteria andTotalVisitNotBetween(Long value1, Long value2) {
            addCriterion("total_visit not between", value1, value2, "totalVisit");
            return (Criteria) this;
        }

        public Criteria andExtend1IsNull() {
            addCriterion("extend1 is null");
            return (Criteria) this;
        }

        public Criteria andExtend1IsNotNull() {
            addCriterion("extend1 is not null");
            return (Criteria) this;
        }

        public Criteria andExtend1EqualTo(String value) {
            addCriterion("extend1 =", value, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend1NotEqualTo(String value) {
            addCriterion("extend1 <>", value, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend1GreaterThan(String value) {
            addCriterion("extend1 >", value, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend1GreaterThanOrEqualTo(String value) {
            addCriterion("extend1 >=", value, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend1LessThan(String value) {
            addCriterion("extend1 <", value, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend1LessThanOrEqualTo(String value) {
            addCriterion("extend1 <=", value, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend1Like(String value) {
            addCriterion("extend1 like", value, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend1NotLike(String value) {
            addCriterion("extend1 not like", value, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend1In(List<String> values) {
            addCriterion("extend1 in", values, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend1NotIn(List<String> values) {
            addCriterion("extend1 not in", values, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend1Between(String value1, String value2) {
            addCriterion("extend1 between", value1, value2, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend1NotBetween(String value1, String value2) {
            addCriterion("extend1 not between", value1, value2, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend2IsNull() {
            addCriterion("extend2 is null");
            return (Criteria) this;
        }

        public Criteria andExtend2IsNotNull() {
            addCriterion("extend2 is not null");
            return (Criteria) this;
        }

        public Criteria andExtend2EqualTo(String value) {
            addCriterion("extend2 =", value, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend2NotEqualTo(String value) {
            addCriterion("extend2 <>", value, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend2GreaterThan(String value) {
            addCriterion("extend2 >", value, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend2GreaterThanOrEqualTo(String value) {
            addCriterion("extend2 >=", value, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend2LessThan(String value) {
            addCriterion("extend2 <", value, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend2LessThanOrEqualTo(String value) {
            addCriterion("extend2 <=", value, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend2Like(String value) {
            addCriterion("extend2 like", value, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend2NotLike(String value) {
            addCriterion("extend2 not like", value, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend2In(List<String> values) {
            addCriterion("extend2 in", values, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend2NotIn(List<String> values) {
            addCriterion("extend2 not in", values, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend2Between(String value1, String value2) {
            addCriterion("extend2 between", value1, value2, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend2NotBetween(String value1, String value2) {
            addCriterion("extend2 not between", value1, value2, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend3IsNull() {
            addCriterion("extend3 is null");
            return (Criteria) this;
        }

        public Criteria andExtend3IsNotNull() {
            addCriterion("extend3 is not null");
            return (Criteria) this;
        }

        public Criteria andExtend3EqualTo(String value) {
            addCriterion("extend3 =", value, "extend3");
            return (Criteria) this;
        }

        public Criteria andExtend3NotEqualTo(String value) {
            addCriterion("extend3 <>", value, "extend3");
            return (Criteria) this;
        }

        public Criteria andExtend3GreaterThan(String value) {
            addCriterion("extend3 >", value, "extend3");
            return (Criteria) this;
        }

        public Criteria andExtend3GreaterThanOrEqualTo(String value) {
            addCriterion("extend3 >=", value, "extend3");
            return (Criteria) this;
        }

        public Criteria andExtend3LessThan(String value) {
            addCriterion("extend3 <", value, "extend3");
            return (Criteria) this;
        }

        public Criteria andExtend3LessThanOrEqualTo(String value) {
            addCriterion("extend3 <=", value, "extend3");
            return (Criteria) this;
        }

        public Criteria andExtend3Like(String value) {
            addCriterion("extend3 like", value, "extend3");
            return (Criteria) this;
        }

        public Criteria andExtend3NotLike(String value) {
            addCriterion("extend3 not like", value, "extend3");
            return (Criteria) this;
        }

        public Criteria andExtend3In(List<String> values) {
            addCriterion("extend3 in", values, "extend3");
            return (Criteria) this;
        }

        public Criteria andExtend3NotIn(List<String> values) {
            addCriterion("extend3 not in", values, "extend3");
            return (Criteria) this;
        }

        public Criteria andExtend3Between(String value1, String value2) {
            addCriterion("extend3 between", value1, value2, "extend3");
            return (Criteria) this;
        }

        public Criteria andExtend3NotBetween(String value1, String value2) {
            addCriterion("extend3 not between", value1, value2, "extend3");
            return (Criteria) this;
        }

        public Criteria andExtend4IsNull() {
            addCriterion("extend4 is null");
            return (Criteria) this;
        }

        public Criteria andExtend4IsNotNull() {
            addCriterion("extend4 is not null");
            return (Criteria) this;
        }

        public Criteria andExtend4EqualTo(String value) {
            addCriterion("extend4 =", value, "extend4");
            return (Criteria) this;
        }

        public Criteria andExtend4NotEqualTo(String value) {
            addCriterion("extend4 <>", value, "extend4");
            return (Criteria) this;
        }

        public Criteria andExtend4GreaterThan(String value) {
            addCriterion("extend4 >", value, "extend4");
            return (Criteria) this;
        }

        public Criteria andExtend4GreaterThanOrEqualTo(String value) {
            addCriterion("extend4 >=", value, "extend4");
            return (Criteria) this;
        }

        public Criteria andExtend4LessThan(String value) {
            addCriterion("extend4 <", value, "extend4");
            return (Criteria) this;
        }

        public Criteria andExtend4LessThanOrEqualTo(String value) {
            addCriterion("extend4 <=", value, "extend4");
            return (Criteria) this;
        }

        public Criteria andExtend4Like(String value) {
            addCriterion("extend4 like", value, "extend4");
            return (Criteria) this;
        }

        public Criteria andExtend4NotLike(String value) {
            addCriterion("extend4 not like", value, "extend4");
            return (Criteria) this;
        }

        public Criteria andExtend4In(List<String> values) {
            addCriterion("extend4 in", values, "extend4");
            return (Criteria) this;
        }

        public Criteria andExtend4NotIn(List<String> values) {
            addCriterion("extend4 not in", values, "extend4");
            return (Criteria) this;
        }

        public Criteria andExtend4Between(String value1, String value2) {
            addCriterion("extend4 between", value1, value2, "extend4");
            return (Criteria) this;
        }

        public Criteria andExtend4NotBetween(String value1, String value2) {
            addCriterion("extend4 not between", value1, value2, "extend4");
            return (Criteria) this;
        }

        public Criteria andExtend5IsNull() {
            addCriterion("extend5 is null");
            return (Criteria) this;
        }

        public Criteria andExtend5IsNotNull() {
            addCriterion("extend5 is not null");
            return (Criteria) this;
        }

        public Criteria andExtend5EqualTo(String value) {
            addCriterion("extend5 =", value, "extend5");
            return (Criteria) this;
        }

        public Criteria andExtend5NotEqualTo(String value) {
            addCriterion("extend5 <>", value, "extend5");
            return (Criteria) this;
        }

        public Criteria andExtend5GreaterThan(String value) {
            addCriterion("extend5 >", value, "extend5");
            return (Criteria) this;
        }

        public Criteria andExtend5GreaterThanOrEqualTo(String value) {
            addCriterion("extend5 >=", value, "extend5");
            return (Criteria) this;
        }

        public Criteria andExtend5LessThan(String value) {
            addCriterion("extend5 <", value, "extend5");
            return (Criteria) this;
        }

        public Criteria andExtend5LessThanOrEqualTo(String value) {
            addCriterion("extend5 <=", value, "extend5");
            return (Criteria) this;
        }

        public Criteria andExtend5Like(String value) {
            addCriterion("extend5 like", value, "extend5");
            return (Criteria) this;
        }

        public Criteria andExtend5NotLike(String value) {
            addCriterion("extend5 not like", value, "extend5");
            return (Criteria) this;
        }

        public Criteria andExtend5In(List<String> values) {
            addCriterion("extend5 in", values, "extend5");
            return (Criteria) this;
        }

        public Criteria andExtend5NotIn(List<String> values) {
            addCriterion("extend5 not in", values, "extend5");
            return (Criteria) this;
        }

        public Criteria andExtend5Between(String value1, String value2) {
            addCriterion("extend5 between", value1, value2, "extend5");
            return (Criteria) this;
        }

        public Criteria andExtend5NotBetween(String value1, String value2) {
            addCriterion("extend5 not between", value1, value2, "extend5");
            return (Criteria) this;
        }

        public Criteria andExtend6IsNull() {
            addCriterion("extend6 is null");
            return (Criteria) this;
        }

        public Criteria andExtend6IsNotNull() {
            addCriterion("extend6 is not null");
            return (Criteria) this;
        }

        public Criteria andExtend6EqualTo(String value) {
            addCriterion("extend6 =", value, "extend6");
            return (Criteria) this;
        }

        public Criteria andExtend6NotEqualTo(String value) {
            addCriterion("extend6 <>", value, "extend6");
            return (Criteria) this;
        }

        public Criteria andExtend6GreaterThan(String value) {
            addCriterion("extend6 >", value, "extend6");
            return (Criteria) this;
        }

        public Criteria andExtend6GreaterThanOrEqualTo(String value) {
            addCriterion("extend6 >=", value, "extend6");
            return (Criteria) this;
        }

        public Criteria andExtend6LessThan(String value) {
            addCriterion("extend6 <", value, "extend6");
            return (Criteria) this;
        }

        public Criteria andExtend6LessThanOrEqualTo(String value) {
            addCriterion("extend6 <=", value, "extend6");
            return (Criteria) this;
        }

        public Criteria andExtend6Like(String value) {
            addCriterion("extend6 like", value, "extend6");
            return (Criteria) this;
        }

        public Criteria andExtend6NotLike(String value) {
            addCriterion("extend6 not like", value, "extend6");
            return (Criteria) this;
        }

        public Criteria andExtend6In(List<String> values) {
            addCriterion("extend6 in", values, "extend6");
            return (Criteria) this;
        }

        public Criteria andExtend6NotIn(List<String> values) {
            addCriterion("extend6 not in", values, "extend6");
            return (Criteria) this;
        }

        public Criteria andExtend6Between(String value1, String value2) {
            addCriterion("extend6 between", value1, value2, "extend6");
            return (Criteria) this;
        }

        public Criteria andExtend6NotBetween(String value1, String value2) {
            addCriterion("extend6 not between", value1, value2, "extend6");
            return (Criteria) this;
        }

        public Criteria andExtend7IsNull() {
            addCriterion("extend7 is null");
            return (Criteria) this;
        }

        public Criteria andExtend7IsNotNull() {
            addCriterion("extend7 is not null");
            return (Criteria) this;
        }

        public Criteria andExtend7EqualTo(String value) {
            addCriterion("extend7 =", value, "extend7");
            return (Criteria) this;
        }

        public Criteria andExtend7NotEqualTo(String value) {
            addCriterion("extend7 <>", value, "extend7");
            return (Criteria) this;
        }

        public Criteria andExtend7GreaterThan(String value) {
            addCriterion("extend7 >", value, "extend7");
            return (Criteria) this;
        }

        public Criteria andExtend7GreaterThanOrEqualTo(String value) {
            addCriterion("extend7 >=", value, "extend7");
            return (Criteria) this;
        }

        public Criteria andExtend7LessThan(String value) {
            addCriterion("extend7 <", value, "extend7");
            return (Criteria) this;
        }

        public Criteria andExtend7LessThanOrEqualTo(String value) {
            addCriterion("extend7 <=", value, "extend7");
            return (Criteria) this;
        }

        public Criteria andExtend7Like(String value) {
            addCriterion("extend7 like", value, "extend7");
            return (Criteria) this;
        }

        public Criteria andExtend7NotLike(String value) {
            addCriterion("extend7 not like", value, "extend7");
            return (Criteria) this;
        }

        public Criteria andExtend7In(List<String> values) {
            addCriterion("extend7 in", values, "extend7");
            return (Criteria) this;
        }

        public Criteria andExtend7NotIn(List<String> values) {
            addCriterion("extend7 not in", values, "extend7");
            return (Criteria) this;
        }

        public Criteria andExtend7Between(String value1, String value2) {
            addCriterion("extend7 between", value1, value2, "extend7");
            return (Criteria) this;
        }

        public Criteria andExtend7NotBetween(String value1, String value2) {
            addCriterion("extend7 not between", value1, value2, "extend7");
            return (Criteria) this;
        }

        public Criteria andExtend8IsNull() {
            addCriterion("extend8 is null");
            return (Criteria) this;
        }

        public Criteria andExtend8IsNotNull() {
            addCriterion("extend8 is not null");
            return (Criteria) this;
        }

        public Criteria andExtend8EqualTo(String value) {
            addCriterion("extend8 =", value, "extend8");
            return (Criteria) this;
        }

        public Criteria andExtend8NotEqualTo(String value) {
            addCriterion("extend8 <>", value, "extend8");
            return (Criteria) this;
        }

        public Criteria andExtend8GreaterThan(String value) {
            addCriterion("extend8 >", value, "extend8");
            return (Criteria) this;
        }

        public Criteria andExtend8GreaterThanOrEqualTo(String value) {
            addCriterion("extend8 >=", value, "extend8");
            return (Criteria) this;
        }

        public Criteria andExtend8LessThan(String value) {
            addCriterion("extend8 <", value, "extend8");
            return (Criteria) this;
        }

        public Criteria andExtend8LessThanOrEqualTo(String value) {
            addCriterion("extend8 <=", value, "extend8");
            return (Criteria) this;
        }

        public Criteria andExtend8Like(String value) {
            addCriterion("extend8 like", value, "extend8");
            return (Criteria) this;
        }

        public Criteria andExtend8NotLike(String value) {
            addCriterion("extend8 not like", value, "extend8");
            return (Criteria) this;
        }

        public Criteria andExtend8In(List<String> values) {
            addCriterion("extend8 in", values, "extend8");
            return (Criteria) this;
        }

        public Criteria andExtend8NotIn(List<String> values) {
            addCriterion("extend8 not in", values, "extend8");
            return (Criteria) this;
        }

        public Criteria andExtend8Between(String value1, String value2) {
            addCriterion("extend8 between", value1, value2, "extend8");
            return (Criteria) this;
        }

        public Criteria andExtend8NotBetween(String value1, String value2) {
            addCriterion("extend8 not between", value1, value2, "extend8");
            return (Criteria) this;
        }

        public Criteria andExtend9IsNull() {
            addCriterion("extend9 is null");
            return (Criteria) this;
        }

        public Criteria andExtend9IsNotNull() {
            addCriterion("extend9 is not null");
            return (Criteria) this;
        }

        public Criteria andExtend9EqualTo(String value) {
            addCriterion("extend9 =", value, "extend9");
            return (Criteria) this;
        }

        public Criteria andExtend9NotEqualTo(String value) {
            addCriterion("extend9 <>", value, "extend9");
            return (Criteria) this;
        }

        public Criteria andExtend9GreaterThan(String value) {
            addCriterion("extend9 >", value, "extend9");
            return (Criteria) this;
        }

        public Criteria andExtend9GreaterThanOrEqualTo(String value) {
            addCriterion("extend9 >=", value, "extend9");
            return (Criteria) this;
        }

        public Criteria andExtend9LessThan(String value) {
            addCriterion("extend9 <", value, "extend9");
            return (Criteria) this;
        }

        public Criteria andExtend9LessThanOrEqualTo(String value) {
            addCriterion("extend9 <=", value, "extend9");
            return (Criteria) this;
        }

        public Criteria andExtend9Like(String value) {
            addCriterion("extend9 like", value, "extend9");
            return (Criteria) this;
        }

        public Criteria andExtend9NotLike(String value) {
            addCriterion("extend9 not like", value, "extend9");
            return (Criteria) this;
        }

        public Criteria andExtend9In(List<String> values) {
            addCriterion("extend9 in", values, "extend9");
            return (Criteria) this;
        }

        public Criteria andExtend9NotIn(List<String> values) {
            addCriterion("extend9 not in", values, "extend9");
            return (Criteria) this;
        }

        public Criteria andExtend9Between(String value1, String value2) {
            addCriterion("extend9 between", value1, value2, "extend9");
            return (Criteria) this;
        }

        public Criteria andExtend9NotBetween(String value1, String value2) {
            addCriterion("extend9 not between", value1, value2, "extend9");
            return (Criteria) this;
        }

        public Criteria andExtend10IsNull() {
            addCriterion("extend10 is null");
            return (Criteria) this;
        }

        public Criteria andExtend10IsNotNull() {
            addCriterion("extend10 is not null");
            return (Criteria) this;
        }

        public Criteria andExtend10EqualTo(String value) {
            addCriterion("extend10 =", value, "extend10");
            return (Criteria) this;
        }

        public Criteria andExtend10NotEqualTo(String value) {
            addCriterion("extend10 <>", value, "extend10");
            return (Criteria) this;
        }

        public Criteria andExtend10GreaterThan(String value) {
            addCriterion("extend10 >", value, "extend10");
            return (Criteria) this;
        }

        public Criteria andExtend10GreaterThanOrEqualTo(String value) {
            addCriterion("extend10 >=", value, "extend10");
            return (Criteria) this;
        }

        public Criteria andExtend10LessThan(String value) {
            addCriterion("extend10 <", value, "extend10");
            return (Criteria) this;
        }

        public Criteria andExtend10LessThanOrEqualTo(String value) {
            addCriterion("extend10 <=", value, "extend10");
            return (Criteria) this;
        }

        public Criteria andExtend10Like(String value) {
            addCriterion("extend10 like", value, "extend10");
            return (Criteria) this;
        }

        public Criteria andExtend10NotLike(String value) {
            addCriterion("extend10 not like", value, "extend10");
            return (Criteria) this;
        }

        public Criteria andExtend10In(List<String> values) {
            addCriterion("extend10 in", values, "extend10");
            return (Criteria) this;
        }

        public Criteria andExtend10NotIn(List<String> values) {
            addCriterion("extend10 not in", values, "extend10");
            return (Criteria) this;
        }

        public Criteria andExtend10Between(String value1, String value2) {
            addCriterion("extend10 between", value1, value2, "extend10");
            return (Criteria) this;
        }

        public Criteria andExtend10NotBetween(String value1, String value2) {
            addCriterion("extend10 not between", value1, value2, "extend10");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}