package mil.nga.giat.geowave.mapreduce;

import java.io.IOException;
import java.util.List;

import mil.nga.giat.geowave.core.index.ByteArrayId;
import mil.nga.giat.geowave.core.store.DataStore;
import mil.nga.giat.geowave.core.store.adapter.AdapterStore;
import mil.nga.giat.geowave.core.store.adapter.statistics.DataStatisticsStore;
import mil.nga.giat.geowave.core.store.index.IndexStore;
import mil.nga.giat.geowave.core.store.index.PrimaryIndex;
import mil.nga.giat.geowave.core.store.query.DistributableQuery;
import mil.nga.giat.geowave.core.store.query.QueryOptions;
import mil.nga.giat.geowave.mapreduce.input.GeoWaveInputKey;

import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.RecordReader;

public interface MapReduceDataStore extends
		DataStore
{

	public RecordReader<GeoWaveInputKey, ?> createRecordReader(
			PrimaryIndex[] indices,
			List<ByteArrayId> adapterIds,
			DistributableQuery query,
			QueryOptions queryOptions,
			AdapterStore adapterStore,
			DataStatisticsStore statsStore,
			IndexStore indexStore,
			boolean isOutputWritable,
			String[] additionalAuthorizations,
			InputSplit inputSplit )
			throws IOException,
			InterruptedException;

	public List<InputSplit> getSplits(
			PrimaryIndex[] indices,
			List<ByteArrayId> adapterIds,
			DistributableQuery query,
			QueryOptions queryOptions,
			AdapterStore adapterStore,
			DataStatisticsStore statsStore,
			IndexStore indexStore,
			String[] additionalAuthorizations,
			Integer minSplits,
			Integer maxSplits )
			throws IOException,
			InterruptedException;
}