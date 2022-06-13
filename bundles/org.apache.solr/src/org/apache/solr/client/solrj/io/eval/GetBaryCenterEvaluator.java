/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.solr.client.solrj.io.eval;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.geometry.euclidean.twod.hull.ConvexHull2D;
import org.apache.solr.client.solrj.io.stream.expr.StreamExpression;
import org.apache.solr.client.solrj.io.stream.expr.StreamFactory;

public class GetBaryCenterEvaluator extends RecursiveObjectEvaluator implements OneValueWorker {
  private static final long serialVersionUID = 1;

  public GetBaryCenterEvaluator(StreamExpression expression, StreamFactory factory) throws IOException {
    super(expression, factory);
  }

  @Override
  public Object doWork(Object value) throws IOException {
    if(!(value instanceof ConvexHull2D)){
      throw new IOException(String.format(Locale.ROOT,"Invalid expression %s - found type %s for value, expecting a ConvexHull2D",toExpression(constructingFactory), value.getClass().getSimpleName()));
    } else {
      ConvexHull2D convexHull2D = (ConvexHull2D)value;
      Vector2D vector2D = (Vector2D)convexHull2D.createRegion().getBarycenter();
      List<Number> vec = new ArrayList<>();
      vec.add(vector2D.getX());
      vec.add(vector2D.getY());
      return vec;
    }
  }
}