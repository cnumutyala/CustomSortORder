CustomSortORder
===============


/*
 * Copyright 2012 by Srinivasrao(cnu.mutyala@gmail.com), Inc. All rights reserved.
 *
 * This software may only be used in connection with an executed license
 * agreement with Srinivas rao. This software may not be copied, published,
 * distributed, modified, sublicensed, sold or shared with any third party
 * without the express written consent of cnu.mutyala@gmail.com.
 */


Custom Sort Order


When you are doing sort please make sure follow below steps

    add sort annotation of you are list getter/setter of field 
    
    @Sort(sortType=SortTypes.ASC, fieldName="<FieldName>",sortCalss="SorderClass")

    Example 
      List<Student> students=new ArrayList<Student>();
      @Sort(sortType=SortTypes.ASC, fieldName="standard",sortCalss=Student.class)
      public List<Student> getStudents() 
      { 
            return students;
      }

   public void setStudents(List<Student> students) 
   {
     this.students = students;
    }

    Call the below class when required sort order of you are list 
    
    SortOrderComparator.sort(this.getClass(),List);

    Example

        SortOrderComparator.sort(this.getClass(),students);

